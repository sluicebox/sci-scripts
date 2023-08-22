;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
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
		(sewer roomVer: 11491)
		(HandsOff)
		(Load rsVIEW 80)
		(Load rsVIEW 0)
		(Load rsVIEW 100)
		(switch gPrevRoomNum
			(72
				(self setScript: climbDOWNscript)
			)
			(east
				(if (== (sewer location:) 90)
					(if (> (sewer oldDistance:) 87)
						(sewer oldDistance: 87)
					)
					((ScriptID 702 2) posn: (- 271 (sewer oldDistance:)) 89) ; theSlime
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(self style: 40 setScript: enterRight)
			)
			(south
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 105)
						(== ((ScriptID 702 2) loop:) 2) ; theSlime
						(> ((ScriptID 702 2) x:) 180) ; theSlime
					)
					(sewer status: 0 location: 0)
				)
				(if (and (== (sewer status:) 3) (== (sewer location:) 90))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 89 142
						setLoop: 0
						setMotion: 0
						setScript: 0
						setCycle: Fwd
					)
				)
				(self setScript: enterSouth style: 30)
			)
			(else
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
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(gEgo init: hide: posn: 244 29)
					(sewer location: 90)
				else
					(gEgo init: hide: posn: 283 -8)
				)
				(self setScript: enterNorth style: 30)
			)
		)
		(super init:)
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
					init: 319 0 319 94 179 94 173 87 181 78 275 0
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
					(sewer location: 0 status: 0)
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

(instance exitDown of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setLoop: 5
					setMotion: PolyPath -9 246 self
				)
			)
			(1
				(if (< ((ScriptID 702 2) y:) 105) ; theSlime
					(sewer location: 0 status: 0)
					(gLongSong2 fade:)
				)
				(gCurRoom newRoom: 105)
			)
		)
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

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: climbUPscript)
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
				(gEgo illegalBits: 0 setMotion: PolyPath 98 129 self)
			)
			(1
				(gEgo
					view: 100
					setLoop: 1
					setCel: 0
					cycleSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo 98 69 self
				)
				(gLongSong fade:)
				(gLongSong2 fade:)
			)
			(2
				(gLongSong number: 0)
				(gLongSong2 number: 0)
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
			)
			(1
				(if (== (sewer location:) 90)
					((ScriptID 702 2) setScript: (ScriptID 702 4)) ; theSlime, theSlimeScript
				)
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
				(NormalEgo)
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
				(gEgo init: hide: posn: 309 96 setMotion: MoveTo 290 96 self)
			)
			(1
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
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

