;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use sewer)
(use MoveToY)
(use eRS)
(use PolyPath)
(use Polygon)
(use Motion)
(use System)

(public
	rm105 0
)

(local
	local0
)

(instance rm105 of SQRoom
	(properties
		picture 105
		horizon 50
		east 110
		picAngle 70
		vanishingX 319
		vanishingY -90
	)

	(method (init)
		(sewer roomVer: 22691)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(110
				(if (or (== (sewer location:) 115) (== (sewer status:) 2))
					(sewer status: 0 location: 0)
				)
				(if (and (== (sewer status:) 8) (== (sewer location:) 105))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 181 32
						setLoop: 0
						setCycle: Fwd
						setScript: slimeLeavingUp
					)
				)
				(self setScript: enterRight style: 40)
			)
			(90
				(if (and (== (sewer location:) 105) (== (sewer status:) 6))
					(Load rsVIEW 76)
					(Load rsSOUND 818)
					(if (not (Random 0 2))
						(sewer status: 3)
					else
						((ScriptID 702 2) ; theSlime
							posn: (Random 286 334) 125
							init:
							setCycle: Fwd
							setScript: slimeLeavingR
						)
					)
				)
				(self setScript: enterNorth style: 30)
			)
			(else
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(self setScript: enterNorth style: 30)
			)
		)
		((ScriptID 702 5) ; theDrip1
			init:
			setLoop: 12
			posn: 233 114
			setPri: 5
			cycleSpeed: 1
			setCycle: Fwd
		)
		(super init:)
		(gEgo init:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 225 0 85 111 78 124 77 132 83 135 319 135 319 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 132 101 132 94 124 99 115 237 0
					yourself:
				)
		)
		(if
			(and
				(== (sewer location:) 0)
				(== (sewer status:) 0)
				(!= gPrevRoomNum 110)
			)
			(sewer status: 1)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitScript)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if
					(and
						(< ((ScriptID 702 2) y:) 85) ; theSlime
						(== (sewer location:) 105)
					)
					(sewer status: 8)
				)
				(if (== ((ScriptID 702 2) loop:) 0) ; theSlime
					(gLongSong vol: 127 playBed:)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
				)
			)
			(
				(and
					(== (sewer status:) 3)
					(!= (sewer location:) 105)
					(> (sewer rmTimer:) 11)
				)
				(sewer location: 0 status: 0)
			)
		)
		(super doit:)
		(if
			(and
				(< (gEgo y:) 171)
				(> (gEgo y:) 126)
				(== (sewer status:) 1)
			)
			(sewer status: 2)
			((ScriptID 702 3) init: hide: setScript: dripScript) ; theDrip
		)
		(if
			(and
				(== (sewer status:) 3)
				(== (sewer location:) 110)
				(< (gEgo x:) 245)
				(< (sewer rmTimer:) 12)
			)
			(sewer location: 105)
			((ScriptID 702 2) ; theSlime
				init:
				show:
				setLoop: 2
				moveSpeed: 0
				posn: 347 125
				setCycle: Fwd
				cycleSpeed: 0
				setScript: (ScriptID 702 4) ; theSlimeScript
			)
		)
		(if
			(and
				(== (sewer status:) 6)
				(== (sewer location:) 90)
				(> (sewer rmTimer:) 8)
			)
			(Load rsVIEW 76)
			(Load rsSOUND 818)
			(sewer location: 0 status: 0)
		)
		(if
			(and
				(< (gEgo x:) 128)
				(== (sewer location:) 110)
				(== (sewer status:) 3)
			)
			(sewer status: 0 location: 0)
		)
		(if (< (gEgo y:) 58)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 4
					setLoop: -1
					setHeading: 46
					setMotion: MoveToY -6 self
				)
			)
			(1
				(if (== (sewer location:) 110)
					(sewer status: 0 location: 0)
				)
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= seconds (Random 2 8))
			)
			(1
				(if (or (> (gEgo x:) 265) (< (gEgo y:) 110))
					(self init:)
				else
					(self cue:)
				)
			)
			(2
				(gLongSong vol: 0 fade: 0 10 10 0)
				(gLongSong2 vol: 127 number: 806 loop: 1 play:)
				((ScriptID 702 3) ; theDrip
					show:
					setLoop: 5
					posn: 139 11
					cel: 0
					cycleSpeed: 1
					setCycle: CT 9 1 self
				)
			)
			(3
				((ScriptID 702 3) setCycle: End) ; theDrip
				((ScriptID 702 2) ; theSlime
					init:
					show:
					setLoop: 7
					cycleSpeed: 1
					setCycle: End self
					posn: 167 41
				)
			)
			(4
				(gLongSong2 vol: 127 number: 819 loop: -1 play:)
				(sewer location: 105 status: 3)
				((ScriptID 702 2) ; theSlime
					setLoop: 0
					setCycle: Fwd
					cycleSpeed: 0
					setScript: (ScriptID 702 4) ; theSlimeScript
					moveSpeed: 1
				)
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
				(gEgo posn: 309 134 setMotion: MoveTo 297 135 self)
				(if (and (== (sewer status:) 3) (== (sewer location:) 105))
					(if (> (sewer oldDistance:) 160)
						(sewer oldDistance: 160)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: (- 320 (sewer oldDistance:)) 125
						moveSpeed: 0
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(gLongSong vol: 0 fade: 0 10 10 0)
					(gLongSong2 vol: 127 number: 819 loop: -1 play:)
				)
				(if (and (== (sewer status:) 6) (== (sewer location:) 105))
					(Load rsVIEW 76)
					(Load rsSOUND 818)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 359 125
						setLoop: 2
						moveSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer status: 4)
				)
				(cond
					(
						(and
							(== (sewer status:) 3)
							(== (sewer location:) 110)
							(< (sewer prevDistance:) 40)
						)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: 359 125
							setLoop: 2
							moveSpeed: 0
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(sewer location: 105)
					)
					((!= (sewer location:) 105)
						(gLongSong2 vol: 0 fade: 0 10 10 0)
						(gLongSong vol: 127 playBed:)
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

(instance enterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 194 32
					setLoop: 5
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 156 62 self
				)
				(if (== (sewer status:) 3)
					(switch (sewer location:)
						(105
							((ScriptID 702 2) ; theSlime
								init:
								hide:
								setLoop: 0
								posn: 118 85
								setScript: (ScriptID 702 4) ; theSlimeScript
							)
							(= state 1)
						)
						(90
							((ScriptID 702 2) ; theSlime
								init:
								hide:
								setLoop: 0
								posn: 256 -26
							)
							(= seconds 2)
							(= local0 1)
						)
					)
				else
					(= state 1)
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(if local0
					((ScriptID 702 2) posn: 240 -16 setScript: (ScriptID 702 4)) ; theSlime, theSlimeScript
					(sewer location: 105)
				)
				(self dispose:)
			)
		)
	)
)

(instance slimeLeavingR of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setMotion: MoveTo 360 125 self) ; theSlime
			)
			(1
				((ScriptID 702 2) dispose:) ; theSlime
				(sewer location: 110)
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
				((ScriptID 702 2) setMotion: MoveTo 225 -7 self) ; theSlime
				(gLongSong vol: 0 fade: 0 10 10 0)
				(gLongSong2 vol: 127 number: 819 loop: 1 play:)
			)
			(1
				((ScriptID 702 2) dispose:) ; theSlime
				(sewer location: 90 status: 6 rmTimer: 0)
				(gLongSong vol: 127 playBed:)
				(gLongSong2 vol: 0 fade: 0 10 10 0)
				(self dispose:)
			)
		)
	)
)

