;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 611)
(include sci.sh)
(use Main)
(use ulence)
(use SQRoom)
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
		(ulence roomVer: 11491)
		(switch gPrevRoomNum
			(614
				(gEgo x: 195)
			)
			(else
				(gEgo x: 24 y: 181)
			)
		)
		(gEgo init: illegalBits: 0 ignoreActors: 1)
		(super init:)
		(self
			setFeatures: building1 building2 grafitti
			setRegions: 706 ; ulence
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 300 189 0 189 0 187 234 187 256 182 291 163 288 149 291 134 265 86 132 86 184 124 138 158 0 163
					yourself:
				)
		)
		(if (and (> (Random 0 100) 50) (== (ulence status:) 1))
			(ulence status: 2)
			(Load rsVIEW 633)
			(Load rsVIEW 635)
			(Load rsSOUND 50)
		)
	)

	(method (doit)
		(if
			(and
				(== (ulence status:) 4)
				(< ((ScriptID 706 2) distanceTo: gEgo) 15) ; theBiker
			)
			(HandsOff)
			(ulence status: 6)
			(gEgo setScript: 0)
			(ulence deathLoop: 1)
			(self setScript: (ScriptID 706 4)) ; theDeathScript
		)
		(cond
			(script 0)
			((and (== (ulence status:) 2) (gEgo inRect: 155 172 175 183))
				(HandsOff)
				(ulence status: 3)
				((ScriptID 706 2) ; theBiker
					view: 633
					init:
					hide:
					posn: -30 (- (gEgo y:) 5)
					setLoop: 0
					setScript: bikerScript
				)
				(gEgo setScript: (ScriptID 706 6)) ; theDodgeL
			)
		)
		(super doit: &rest)
	)
)

(instance building1 of Feature
	(properties
		x 85
		y 91
		nsTop 32
		nsBottom 151
		nsRight 170
		description {*** back of bar}
		sightAngle 45
		onMeCheck 2
		lookStr {This must be the back of the bar. Some fading grafitti adorns the wall.}
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
		description {*** Toys B Us building.}
		sightAngle 45
		onMeCheck 8
		lookStr {You see the Droids-B-Us store in the distance.}
	)
)

(instance bikerScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong
					vol: 5
					number: 50
					loop: -1
					playBed:
					fade: 127 10 10 0
				)
				(= seconds 3)
			)
			(1
				((ScriptID 706 2) ; theBiker
					show:
					setMotion: MoveTo 50 (- (gEgo y:) 5) self
				)
			)
			(2
				(ulence status: 4)
				(HandsOn)
				((ScriptID 706 2) ; theBiker
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo 171 (- (gEgo y:) 5) self
				)
			)
			(3
				((ScriptID 706 2) posn: 202 160 setLoop: 6) ; theBiker
				(= cycles 1)
			)
			(4
				((ScriptID 706 2) setMotion: MoveTo 244 141 self) ; theBiker
			)
			(5
				((ScriptID 706 2) posn: 250 131 setLoop: 3) ; theBiker
				(= cycles 1)
			)
			(6
				((ScriptID 706 2) setMotion: MoveTo 250 99 self) ; theBiker
			)
			(7
				((ScriptID 706 2) posn: 225 87 setLoop: 7) ; theBiker
				(= cycles 1)
			)
			(8
				((ScriptID 706 2) setMotion: MoveTo 179 73 self) ; theBiker
			)
			(9
				((ScriptID 706 2) ; theBiker
					setPri: 4
					setLoop: 1
					setMotion: MoveTo 46 73 self
				)
			)
			(10
				(gLongSong fade:)
				((ScriptID 706 2) hide:) ; theBiker
				(= seconds 3)
			)
			(11
				(if (== (ulence status:) 5)
					(ulence status: 1)
					(proc706_1)
					(HandsOn)
					(gEgo setScript: 0)
				else
					(EgoDead 611 0) ; "*** You're so STUPID!!!"
				)
				(self dispose:)
			)
		)
	)
)

(instance grafitti of Feature
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

