;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Motion)
(use System)

(public
	rm100 0
)

(instance rm100 of SQRoom
	(properties
		picture 100
		horizon 48
		north 85
		south 115
		west 95
		picAngle 70
		vanishingX 0
		vanishingY -50
	)

	(method (init)
		(sewer roomVer: 11491)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(95
				(HandsOn)
				(if (== (sewer location:) 100)
					(cond
						((> (sewer oldDistance:) 68)
							((ScriptID 702 2) posn: 121 91) ; theSlime
						)
						((> (sewer oldDistance:) 40)
							((ScriptID 702 2) posn: 68 91) ; theSlime
						)
						(else
							((ScriptID 702 2) posn: 37 91) ; theSlime
							(sewer status: 4)
						)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(self style: 41 setScript: enterLeft)
			)
			(north
				(self setScript: enterNorth style: 30)
			)
			(else
				(self setScript: enterSouth style: 30)
			)
		)
		(super init:)
		(gEgo show:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 58 0 319 0 319 189 284 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 46 0 150 87 149 94 0 94 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 99 159 99 270 189 0 189
					yourself:
				)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(if
					(and
						(== (sewer location:) 100)
						(== (sewer status:) 3)
						(> ((ScriptID 702 2) y:) 120) ; theSlime
					)
					(sewer location: 115)
				)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitNorth)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: exitSouth)
			)
		)
		(super doit: &rest)
		(if (< (gEgo y:) 50)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: -1 setHeading: 132 self)
			)
			(1
				(gEgo setLoop: 4 setMotion: MoveTo 325 239 self)
			)
			(2
				(gCurRoom newRoom: 115)
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
				(gEgo
					init:
					setLoop: 4
					illegalBits: 0
					ignoreActors: 1
					posn: 38 -6
					setMotion: MoveTo 80 27 self
				)
			)
			(1
				(if (and (== (sewer status:) 3) (== (sewer location:) 85))
					(if (< (sewer prevDistance:) 55)
						((ScriptID 702 2) posn: 36 -16) ; theSlime
					else
						((ScriptID 702 2) posn: 20 -27) ; theSlime
					)
					((ScriptID 702 2) ; theSlime
						init:
						setLoop: 1
						setCycle: Fwd
						cycleSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 100)
				)
				(gEgo setMotion: MoveTo 111 51 self)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitNorth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setLoop: -1
					illegalBits: 0
					ignoreActors: 1
					setHeading: 311 self
				)
			)
			(1
				(gEgo setLoop: 7 setMotion: MoveTo 38 -6 self)
			)
			(2
				(gCurRoom newRoom: 85)
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
				(if (== (sewer status:) 6)
					(gEgo
						init:
						hide:
						view: 76
						normal: 0
						setLoop: 0
						posn: 284 189
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 1
						posn: 284 182
						setCycle: Fwd
						cycleSpeed: 0
						setScript: (ScriptID 702 1) ; theDeathScript
					)
				else
					(gEgo
						init:
						setLoop: 7
						illegalBits: 0
						ignoreActors: 1
						posn: 336 249
						setMotion: MoveTo 274 187 self
					)
					(if (== (sewer location:) 100)
						(switch (sewer oldDistance:)
							(4
								((ScriptID 702 2) posn: 159 85) ; theSlime
							)
							(3
								((ScriptID 702 2) posn: 175 98) ; theSlime
							)
							(2
								((ScriptID 702 2) posn: 221 127) ; theSlime
							)
							(1
								((ScriptID 702 2) posn: 225 138) ; theSlime
							)
						)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							setLoop: 1
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
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

(instance enterLeft of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo init: hide: posn: 12 98 setMotion: MoveTo 31 97 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

