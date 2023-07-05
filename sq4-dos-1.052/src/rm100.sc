;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use sewer)
(use eRS)
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
		(sewer roomVer: 22891)
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
					(gLongSong2 number: 819 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 2
						moveSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(self style: 41 setScript: enterLeft)
			)
			(85
				(self setScript: enterNorth style: 30)
			)
			(115
				(if (or (== (sewer status:) 1) (== (sewer status:) 2))
					(sewer status: 0 location: 0)
				)
				(if (and (== (sewer location:) 100) (== (sewer status:) 8))
					(if (> (Random 0 100) 50)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							setCycle: Fwd
							setLoop: 2
							posn: 11 93
							setScript: slimeLeavingL
						)
					else
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							setCycle: Fwd
							setLoop: 1
							posn: 72 16
							setScript: slimeLeavingUp
						)
					)
				)
				(self setScript: enterSouth style: 30)
			)
			(else
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(self setScript: enterSouth style: 30)
			)
		)
		((ScriptID 702 5) ; theDrip1
			init:
			setLoop: 10
			posn: 90 44
			setPri: 5
			cycleSpeed: 1
			setCycle: Fwd
		)
		((ScriptID 702 6) ; theDrip2
			init:
			setLoop: 11
			posn: 292 130
			setScript: daDripScript
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
			((== (gEgo edgeHit:) 4)
				(if (OneOf (sewer location:) 115 85)
					(sewer status: 0 location: 0)
				)
				(if
					(and
						(== (sewer location:) 100)
						(== (sewer status:) 3)
						(> ((ScriptID 702 2) y:) 135) ; theSlime
					)
					(sewer status: 8)
				)
			)
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitNorth)
			)
			((== (gEgo edgeHit:) 3)
				(HandsOff)
				(self setScript: exitSouth)
			)
			(
				(and
					(> (sewer rmTimer:) 5)
					(== (sewer location:) 95)
					(> (gEgo x:) 146)
				)
				(sewer status: 0 location: 0)
			)
		)
		(if
			(and
				(> (sewer rmTimer:) 15)
				(== (sewer location:) 85)
				(== (sewer status:) 8)
			)
			(sewer status: 0 location: 0)
		)
		(super doit: &rest)
		(if (< (gEgo y:) 50)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0002)
				(== ((ScriptID 702 2) loop:) 1) ; theSlime
			)
			(sewer cantDie: 1)
		else
			(sewer cantDie: 0)
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
				(if (OneOf (sewer location:) 95 85)
					(sewer location: 0 status: 0)
				)
				(if
					(and
						(== (sewer location:) 100)
						(< ((ScriptID 702 2) y:) 120) ; theSlime
					)
					(sewer status: 8)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
				)
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
				(if (and (== (sewer status:) 2) (== (sewer location:) 85))
					(if (> (Random 0 100) 50)
						(gLongSong vol: 127 playBed:)
						(gLongSong2 vol: 0 fade: 0 10 10 0)
						(sewer status: 6)
					else
						(sewer status: 3)
					)
				)
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
				(if (and (== (sewer location:) 85) (== (sewer status:) 3))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 20 -27
						setLoop: 1
						setCycle: Fwd
						cycleSpeed: 0
						setScript: bringInSlime
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
				(if (and (== (sewer location:) 100) (== (sewer status:) 3))
					(gLongSong vol: 127 playBed:)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
				)
				(if (== (sewer location:) 95)
					(sewer location: 0 status: 0)
				)
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
					(if (and (== (sewer location:) 100) (== (sewer status:) 3))
						(switch (sewer oldDistance:)
							(4
								((ScriptID 702 2) posn: 159 85) ; theSlime
							)
							(3
								((ScriptID 702 2) posn: 175 98) ; theSlime
							)
							(2
								((ScriptID 702 2) posn: 218 127) ; theSlime
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
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
					)
				)
			)
			(1
				(if (and (== (sewer location:) 115) (== (sewer status:) 3))
					((ScriptID 702 2) ; theSlime
						posn: 300 198
						init:
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer status: 4)
				)
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
				(if (and (== (sewer location:) 100) (== (sewer status:) 8))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 270 174
						setLoop: 1
						moveSpeed: 0
						setScript: slimeLeavingDown
					)
				)
				(if
					(and
						(== (sewer location:) 95)
						(== (sewer status:) 3)
						(== ((ScriptID 702 2) loop:) 2) ; theSlime
						(< (sewer prevDistance:) 35)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: -33 89
						setLoop: 2
						moveSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 100)
					(gLongSong2 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
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

(instance slimeLeavingDown of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setCycle: Fwd setMotion: MoveTo 302 208 self) ; theSlime
			)
			(1
				(sewer location: 115 status: 3)
				((ScriptID 702 2) posn: 1000 1000 dispose:) ; theSlime
				(self dispose:)
			)
		)
	)
)

(instance slimeLeavingUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setMotion: MoveTo 31 -21 self) ; theSlime
			)
			(1
				(sewer location: 85 status: 6 rmTimer: 0)
				((ScriptID 702 2) posn: 1000 1000 dispose:) ; theSlime
				(self dispose:)
			)
		)
	)
)

(instance slimeLeavingL of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setMotion: MoveTo -40 93 self) ; theSlime
			)
			(1
				(sewer location: 95 status: 6)
				((ScriptID 702 2) posn: 1000 1000 dispose:) ; theSlime
				(self dispose:)
			)
		)
	)
)

(instance bringInSlime of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 7)
				(if (> (sewer prevDistance:) 50)
					(= cycles 15)
				)
				(if (> (sewer prevDistance:) 100)
					(= cycles 25)
				)
			)
			(1
				(if (!= (gLongSong2 number:) 819)
					(gLongSong2 number: 819 vol: 127 playBed:)
				)
				((ScriptID 702 2) show: setScript: (ScriptID 702 4)) ; theSlime, theSlimeScript
				(self dispose:)
			)
		)
	)
)

