;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use Interface)
(use sewer)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Rev)
(use Motion)
(use System)

(public
	rm090 0
)

(instance rm090 of SQRoom
	(properties
		picture 90
		horizon 47
		north 75
		east 95
		south 105
		west 105
		picAngle 70
		vanishingX 319
		vanishingY -50
	)

	(method (init)
		(sewer roomVer: 3591)
		(HandsOff)
		(Load rsVIEW 80)
		(Load rsVIEW 0)
		(Load rsVIEW 100)
		(switch gPrevRoomNum
			(72
				(self setScript: climbDOWNscript)
			)
			(95
				(gEgo posn: 309 96)
				(if (and (== (sewer status:) 3) (== (sewer location:) 90))
					(if (> (sewer oldDistance:) 87)
						(sewer oldDistance: 87)
					)
					((ScriptID 702 2) posn: (- 271 (sewer oldDistance:)) 89) ; theSlime
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 2
						moveSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(gLongSong2 vol: 127 loop: -1 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
				)
				(self style: 40 setScript: enterRight)
			)
			(105
				(if (or (== (sewer status:) 1) (== (sewer status:) 2))
					(sewer status: 0 location: 0)
				)
				(if (and (== (sewer location:) 90) (== (sewer status:) 6))
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					(sewer status: 3 prevDistance: 20)
				)
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 105)
						(== ((ScriptID 702 2) loop:) 2) ; theSlime
					)
					(if (> ((ScriptID 702 2) x:) 180) ; theSlime
						(sewer status: 0 location: 0)
					else
						(sewer status: 6 rmTimer: 0)
					)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(self setScript: enterSouth style: 30)
			)
			(north
				(if (and (== (sewer status:) 3) (== (sewer location:) 75))
					(cond
						((> (sewer prevDistance:) 70)
							((ScriptID 702 2) posn: 305 -32) ; theSlime
						)
						((> (sewer prevDistance:) 50)
							((ScriptID 702 2) posn: 300 -24) ; theSlime
						)
						((> (sewer prevDistance:) 20)
							((ScriptID 702 2) posn: 280 -10) ; theSlime
						)
						(else
							((ScriptID 702 2) posn: 274 -8) ; theSlime
						)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 0
						setCycle: Fwd
						cycleSpeed: 0
						moveSpeed: 1
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(gEgo init: hide: posn: 244 29)
					(sewer location: 90)
				else
					(gEgo init: hide: posn: 283 -8)
				)
				(self setScript: enterNorth style: 30)
			)
			(else
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo init: hide: posn: 283 -8)
				(self setScript: enterNorth style: 30)
			)
		)
		(super init:)
		((ScriptID 702 5) ; theDrip1
			init:
			setLoop: 6
			posn: 229 44
			setPri: 5
			ignoreActors: 1
			cycleSpeed: 1
			setCycle: Fwd
		)
		((ScriptID 702 6) init: setLoop: 7 posn: 27 130 setScript: daDripScript) ; theDrip2
		(gEgo show:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setFeatures: theLadder
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 0 189 0 0 263 0 38 189 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 48 189 150 105 163 101 319 101 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 94 179 94 170 88 181 78 275 0
					yourself:
				)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (== (sewer location:) 105)
					(sewer status: 0 location: 0)
				)
				(if
					(and
						(== (sewer location:) 90)
						(== (sewer status:) 3)
						(> ((ScriptID 702 2) y:) 135) ; theSlime
					)
					(sewer status: 8)
				)
				(if (> (sewer distance:) 30)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitUp)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: exitDown)
			)
			((and (== (sewer status:) 6) (== (sewer location:) 105))
				(Load rsSOUND 818)
				(Load rsVIEW 76)
				(if (or (< (gEgo y:) 143) (> (sewer rmTimer:) 7))
					(sewer location: 0 status: 0)
				)
			)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0002)
				(== ((ScriptID 702 2) loop:) 0) ; theSlime
			)
			(sewer cantDie: 1)
		else
			(sewer cantDie: 0)
		)
		(if (< (gEgo y:) 50)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(super doit: &rest)
	)
)

(instance exitUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setLoop: 6
					setMotion: PolyPath 283 -8 self
				)
			)
			(1
				(if (== (sewer location:) 105)
					(sewer status: 0 location: 0)
				)
				(if (and (== (sewer location:) 90) (== (sewer status:) 3))
					(sewer status: 6)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(gCurRoom newRoom: 75)
			)
		)
	)
)

(instance theLadder of Feature
	(properties
		x 75
		y 107
		nsTop 18
		nsLeft 73
		nsBottom 121
		nsRight 100
		description {ladder}
		sightAngle 45
		lookStr {A sturdy metal ladder is attached to the wall here. At the top of the ladder there appears to be something resembling the underside of a manhole cover.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Do
				(HandsOff)
				(cond
					((!= (sewer status:) 4)
						(gCurRoom setScript: climbUPscript)
					)
					(
						(and
							(> ((ScriptID 702 2) y:) 100) ; theSlime
							(== ((ScriptID 702 2) loop:) 0) ; theSlime
							(== (sewer status:) 3)
						)
						(Print 90 0) ; "Not now!"
					)
					(else
						(gCurRoom setScript: climbUPscript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance climbUPscript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 98 129 self)
			)
			(1
				(gEgo
					posn: 98 129
					view: 100
					setLoop: 1
					setCel: 0
					cycleSpeed: 0
					ignoreActors: 1
					setCycle: Fwd
					setMotion: MoveTo 98 72 self
				)
				(gLongSong fade:)
				(gLongSong2 fade:)
			)
			(2
				(gLongSong number: 0)
				(gLongSong2 number: 0)
				(gEgo setCel: 255 ignoreActors: 0)
				(gCurRoom newRoom: 72)
			)
		)
	)
)

(instance climbDOWNscript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong vol: 127 number: 805 loop: -1 playBed:)
				(gEgo
					init:
					view: 100
					posn: 98 69
					illegalBits: 0
					ignoreActors: 1
					setCel: 255
					setLoop: 1
					cycleSpeed: 0
				)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: Rev setMotion: MoveTo 98 129 self)
			)
			(2
				(gEgo view: 0)
				(NormalEgo)
				(= cycles 1)
			)
			(3
				(gEgo setLoop: -1 setHeading: 90 self)
			)
			(4
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: hide: setMotion: MoveTo 290 96 self)
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 95)
						(< (sewer prevDistance:) 30)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 357 89
						setLoop: 2
						moveSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(gLongSong2 vol: 127 loop: -1 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
					(sewer location: 90)
				)
				(if (and (== (sewer location:) 90) (== (sewer status:) 8))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 53 173
						setLoop: 0
						moveSpeed: 0
						setScript: slimeLeaving
					)
				)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					hide:
					posn: -9 246
					setLoop: 6
					setMotion: PolyPath 53 180 self
				)
				(if (and (== (sewer status:) 3) (== (sewer location:) 90))
					((ScriptID 702 2) posn: 75 156) ; theSlime
					(if (> (sewer prevDistance:) 30)
						((ScriptID 702 2) posn: 90 144) ; theSlime
					)
					(if (> (sewer prevDistance:) 50)
						((ScriptID 702 2) posn: 107 128) ; theSlime
					)
					(if (> (sewer prevDistance:) 70)
						((ScriptID 702 2) posn: 140 100) ; theSlime
					)
					(if (> (sewer prevDistance:) 90)
						((ScriptID 702 2) posn: 176 72) ; theSlime
					)
					(if (> (sewer prevDistance:) 110)
						((ScriptID 702 2) posn: 239 21) ; theSlime
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 0
						moveSpeed: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer status: 4)
					(gLongSong2 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
				)
			)
			(1
				(if
					(and
						(== (sewer location:) 105)
						(!= ((ScriptID 702 2) loop:) 2) ; theSlime
					)
					((ScriptID 702 2) ; theSlime
						init:
						posn: 22 199
						setLoop: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 90)
				)
				(if
					(and
						(== (sewer location:) 90)
						(== (sewer status:) 3)
						(== ((ScriptID 702 2) loop:) 0) ; theSlime
					)
					((ScriptID 702 2) moveSpeed: 1) ; theSlime
				)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterNorth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 5 setMotion: PolyPath 208 56 self)
				(if (and (== (sewer status:) 6) (== (sewer location:) 90))
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 171 79
						setLoop: 0
						setCycle: Fwd
						cycleSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer status: 4)
				)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitDown of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setHeading: 225 self setMotion: 0)
			)
			(1
				(gEgo setLoop: 5 setMotion: PolyPath -9 246 self)
			)
			(2
				(if (< ((ScriptID 702 2) y:) 105) ; theSlime
					(sewer location: 0 status: 0)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(gCurRoom newRoom: 105)
			)
		)
	)
)

(instance daDripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 6) setCycle: End self) ; theDrip2
			)
			(1
				(= cycles (Random 5 20))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance slimeLeaving of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setCycle: Fwd setMotion: MoveTo 19 207 self) ; theSlime
			)
			(1
				(sewer location: 105 status: 3)
				((ScriptID 702 2) posn: 1000 1000 dispose:) ; theSlime
				(self dispose:)
			)
		)
	)
)

