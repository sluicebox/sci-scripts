;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Motion)
(use System)

(public
	rm115 0
)

(local
	local0
)

(instance rm115 of SQRoom
	(properties
		picture 115
		horizon 50
		west 110
		picAngle 70
		vanishingX 0
		vanishingY -65
	)

	(method (init)
		(sewer roomVer: 11491)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(100
				(gEgo posn: 88 -1)
				(self setScript: enterNorth style: 30)
				(if (!= (sewer location:) 100)
					(sewer status: 1)
				)
			)
			(west
				(self style: 41 setScript: enterLeft)
			)
			(else
				(gEgo init: posn: 18 128)
				(NormalEgo)
			)
		)
		(super init:)
		(gEgo init: show:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 81 0 233 121 227 129 0 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 189 0 189 0 136 241 136 248 129 243 118 95 0
					yourself:
				)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				((ScriptID 702 2) setScript: 0) ; theSlime
				(self setScript: exitNorth)
			)
			((== (gEgo edgeHit:) 4)
				(if (> (sewer distance:) 39)
					(gLongSong2 fade:)
				)
				(if (or (< ((ScriptID 702 2) y:) 80) (== (sewer location:) 100)) ; theSlime
					(gLongSong2 fade:)
					(sewer location: 0 status: 0)
				)
			)
		)
		(super doit: &rest)
		(if (and (!= gPrevRoomNum 110) (== (sewer status:) 1))
			(sewer status: 2)
			((ScriptID 702 3) init: hide: setScript: dripScript) ; theDrip
			(= local0 1)
		)
		(if
			(and
				(== (sewer location:) 110)
				(> (gEgo x:) 121)
				(> (sewer prevDistance:) 50)
			)
			(sewer location: 0 status: 0)
		)
	)
)

(instance exitNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 4
					illegalBits: 0
					ignoreActors: 1
					setLoop: 7
					setMotion: MoveTo 89 0 self
				)
			)
			(1
				(if (and (== (sewer location:) 100) (> (sewer rmTimer:) 30))
					(sewer location: 0 status: 0)
				)
				(if (== (sewer location:) 110)
					(sewer location: 0 status: 0)
				)
				((ScriptID 702 2) posn: 1000 1000) ; theSlime
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(if (< (gEgo y:) 105)
					(self init:)
				else
					(self cue:)
				)
			)
			(2
				(gLongSong fade: 80 10 10 0)
				(gLongSong2 number: 806 loop: 1 play:)
				((ScriptID 702 3) ; theDrip
					show:
					setLoop: 6
					posn: 186 14
					cel: 0
					cycleSpeed: 2
					setCycle: CT 9 1 self
				)
			)
			(3
				((ScriptID 702 3) cycleSpeed: 1 setCycle: End) ; theDrip
				((ScriptID 702 2) ; theSlime
					init:
					setLoop: 8
					cycleSpeed: 1
					setCycle: End self
					posn: 161 48
				)
			)
			(4
				(gLongSong fade: 80 10 10 0)
				(gLongSong2 number: 806 loop: 1 play:)
				(sewer status: 3 location: 115)
				((ScriptID 702 2) ; theSlime
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 0
					setScript: (ScriptID 702 4) ; theSlimeScript
				)
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
					ignoreHorizon: 1
					setLoop: 4
					setMotion: MoveTo 123 29 self
				)
			)
			(1
				(if (and (== (sewer status:) 3) (== (sewer location:) 100))
					(if (< (sewer prevDistance:) 60)
						((ScriptID 702 2) posn: 79 -16) ; theSlime
					else
						((ScriptID 702 2) posn: 73 -22) ; theSlime
					)
					((ScriptID 702 2) ; theSlime
						init:
						setLoop: 1
						setCycle: Fwd
						cycleSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 115)
					(= local0 1)
				)
				(gEgo setMotion: MoveTo 159 59 self)
			)
			(2
				(HandsOn)
				(NormalEgo)
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
				(gEgo init: hide: posn: 10 133 setMotion: MoveTo 30 133 self)
				(cond
					(
						(and
							(== (sewer status:) 3)
							(== (sewer location:) 110)
							(< (sewer prevDistance:) 50)
						)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: -32 125
							setLoop: 2
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(sewer location: 115)
					)
					((and (== (sewer status:) 3) (== (sewer location:) 115))
						(if (> (sewer oldDistance:) 140)
							((ScriptID 702 2) posn: 203 127) ; theSlime
						else
							((ScriptID 702 2) posn: (sewer oldDistance:) 127) ; theSlime
						)
						(sewer status: 4)
						((ScriptID 702 2) ; theSlime
							setLoop: 2
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(gLongSong2 play:)
					)
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

