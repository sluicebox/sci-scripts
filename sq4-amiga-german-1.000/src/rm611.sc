;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 611)
(include sci.sh)
(use Main)
(use Interface)
(use ulence)
(use eRS)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm611 0
)

(instance rm611 of SQRoom
	(properties
		picture 611
		horizon 90
		north 614
		west 610
	)

	(method (init)
		(ulence roomVer: 3791)
		(switch gPrevRoomNum
			(614
				(gEgo x: 195)
			)
			(610
				(if (< (gEgo y:) 166)
					(gEgo y: 166)
				)
				(gLongSong2 number: 0 vol: 0 stop:)
			)
			(else
				(gEgo x: 24 y: 181)
			)
		)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(super init:)
		(self
			setFeatures: building1 building2 graffiti
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 300 189 263 189 198 189 256 182 291 163 288 149 291 134 265 86 132 86 149 101 169 107 179 124 170 140 138 158 0 163
					yourself:
				)
		)
		(if (and (> (Random 0 100) 20) (== (ulence status:) 1))
			(ulence status: 2 bikerComing: 1)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		)
		((ScriptID 706 7) init: nsLeft: 0 nsTop: 55 nsBottom: 189 nsRight: 319) ; theSand
		((ScriptID 706 8) init: nsLeft: 0 nsTop: 0 nsBottom: 55 nsRight: 319) ; theDunes
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 1) distanceTo: gEgo) 15) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 1)
			(self setScript: (ScriptID 706 3)) ; theDeathScript
		)
		(cond
			(script 0)
			((and (== (ulence status:) 2) (gEgo inRect: 155 172 175 183))
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 1) ; theBiker
					view: 633
					init:
					hide:
					posn: -30 (- (gEgo y:) 5)
					setLoop: 0
					setScript: runOver
				)
				(gEgo setScript: (ScriptID 706 5)) ; theDodgeL
			)
		)
		(super doit: &rest)
	)
)

(instance runOver of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(ulence egoBusy: 1)
				(gLongSong
					vol: 25
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 6) init: play:) ; theBikeSound
				((ScriptID 706 1) ; theBiker
					show:
					setMotion: MoveTo 50 (- (gEgo y:) 5) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 1) ; theBiker
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 171 (- (gEgo y:) 5) self
				)
			)
			(3
				((ScriptID 706 1) posn: 202 160 setLoop: 6) ; theBiker
				(= cycles 1)
			)
			(4
				((ScriptID 706 1) setMotion: MoveTo 244 141 self) ; theBiker
			)
			(5
				((ScriptID 706 1) posn: 250 131 setLoop: 3) ; theBiker
				(= cycles 1)
			)
			(6
				((ScriptID 706 1) setMotion: MoveTo 250 99 self) ; theBiker
			)
			(7
				((ScriptID 706 1) posn: 225 87 setLoop: 7) ; theBiker
				(= cycles 1)
			)
			(8
				((ScriptID 706 1) setMotion: MoveTo 179 73 self) ; theBiker
			)
			(9
				((ScriptID 706 1) ; theBiker
					setPri: 4
					setLoop: 1
					setMotion: MoveTo 46 73 self
				)
			)
			(10
				((ScriptID 706 6) fade:) ; theBikeSound
				(gLongSong fade:)
				((ScriptID 706 1) hide:) ; theBiker
				(= seconds 3)
			)
			(11
				(if (!= (ulence status:) 6)
					(ulence status: 1 fieldOff: 0 bikerComing: 0 egoBusy: 0)
					(gEgo setScript: 0)
					(Print 611 0) ; "Boy, that was close!"
				)
				(= cycles 2)
			)
			(12
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance graffiti of Feature
	(properties
		x 30
		y 117
		nsTop 85
		nsBottom 150
		nsRight 60
		description {gr}
		sightAngle 45
		lookStr {You don't know what it says but you're sure it's not flattering.}
	)
)

(instance building1 of Feature
	(properties
		x 85
		y 91
		nsTop 32
		nsBottom 151
		nsRight 170
		description {back of bar}
		sightAngle 45
		onMeCheck 2
		lookStr {This must be the back of the bar. Some fading graffiti adorns the wall.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Smell
				(Print 611 1) ; "Back here, the bar smells like everything they didn't want stinking up the front."
			)
			(10 ; Taste
				(Print 611 2) ; "An interesting mix of flavors! Stale Keronian ale, regurgitated Keronian ale, and Keronian ale that's otherwise been used and disposed of."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance building2 of Feature
	(properties
		x 137
		y 46
		nsTop 23
		nsLeft 63
		nsBottom 70
		nsRight 212
		description {Toys B Us building.}
		sightAngle 45
		onMeCheck 8
		lookStr {You see the Droids-B-Us store in the distance.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Smell
				(Print 611 3) ; "From here, you can't really smell the Droids-B-Us building."
			)
			(10 ; Taste
				(Print 611 4) ; "You'll have to get closer if you want to lick the Droids-B-Us building."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

