;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Motion)
(use System)

(public
	rm110 0
)

(local
	local0
)

(instance rm110 of SQRoom
	(properties
		picture 110
		horizon 50
		east 115
		west 105
		picAngle 70
	)

	(method (init &tmp temp0)
		(sewer roomVer: 11791)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(95
				(if (== (sewer status:) 3)
					(switch (sewer location:)
						(95
							((ScriptID 702 2) ; theSlime
								posn: 158 (- 30 (sewer prevDistance:))
							)
							((ScriptID 702 2) ; theSlime
								init:
								hide:
								setLoop: 3
								setCycle: Fwd
								setScript: (ScriptID 702 4) ; theSlimeScript
							)
							(sewer cantDie: 1 location: 110)
						)
						(110
							((ScriptID 702 2) ; theSlime
								init:
								hide:
								posn: 157 108
								setLoop: 3
								setCycle: Fwd
								setScript: (ScriptID 702 4) ; theSlimeScript
							)
							(sewer status: 4)
						)
					)
				)
				(gEgo init: hide: x: 161)
				(= temp0 42)
				(HandsOn)
			)
			(east
				(= temp0 40)
				(HandsOff)
				(self setScript: enterRight)
			)
			(west
				(= temp0 41)
				(HandsOff)
				(self setScript: enterLeft)
			)
			(else
				(gEgo init: hide: posn: 20 133)
				(NormalEgo)
			)
		)
		(self style: temp0)
		(super init:)
		((ScriptID 702 2) show:) ; theSlime
		(gEgo show:)
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 146 0 146 120 139 130 0 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 164 0 319 0 319 130 168 130 164 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 136 319 136 319 189 0 189
					yourself:
				)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitScript)
			)
			((or (== (gEgo edgeHit:) EDGE_LEFT) (== (gEgo edgeHit:) EDGE_RIGHT))
				(if (== (sewer location:) 105)
					(gLongSong2 play:)
				)
				(if (and (== (sewer location:) 110) (> (sewer distance:) 39))
					(gLongSong2 fade:)
				)
				(if
					(and
						(== (sewer status:) 3)
						(or
							(== ((ScriptID 702 2) y:) 1000) ; theSlime
							(< ((ScriptID 702 2) y:) 50) ; theSlime
						)
					)
					(sewer status: 0 location: 0)
				)
			)
			(
				(and
					(== (sewer status:) 3)
					(> (sewer rmTimer:) 11)
					(!= (sewer location:) 110)
				)
				(sewer location: 0 status: 0)
			)
		)
		(super doit: &rest)
		(if
			(and
				(== (sewer status:) 3)
				(== (sewer location:) 115)
				(< (gEgo x:) 245)
				(< (sewer rmTimer:) 12)
			)
			(sewer location: 110)
			((ScriptID 702 2) ; theSlime
				init:
				setLoop: 2
				posn: 346 125
				setCycle: Fwd
				cycleSpeed: 0
				setScript: (ScriptID 702 4) ; theSlimeScript
			)
		)
		(if
			(and
				(> (gEgo x:) 85)
				(== (sewer status:) 3)
				(== (sewer location:) 105)
			)
			(sewer location: 110)
			((ScriptID 702 2) ; theSlime
				init:
				setLoop: 2
				posn: -39 125
				setCycle: Fwd
				cycleSpeed: 0
				setScript: (ScriptID 702 4) ; theSlimeScript
			)
			(gLongSong2 play:)
		)
		(if (< (gEgo y:) 63)
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
				(if
					(and
						(== ((ScriptID 702 2) loop:) 3) ; theSlime
						(> (sewer distance:) 29)
					)
					((ScriptID 702 2) setScript: 0 posn: 1000 1000) ; theSlime
				)
				(gEgo
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x:) -26 self
				)
			)
			(1
				(if (== ((ScriptID 702 2) loop:) 3) ; theSlime
					((ScriptID 702 2) hide:) ; theSlime
				)
				(if (== (sewer location:) 110)
					(gLongSong2 fade:)
				)
				(gCurRoom newRoom: 95)
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
				(gEgo init: hide: posn: 10 133 setMotion: MoveTo 25 133 self)
				(if (and (== (sewer status:) 3) (== (sewer location:) 110))
					(gLongSong2 play:)
					(if (> (sewer oldDistance:) 109)
						(sewer oldDistance: 109)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: (sewer oldDistance:) 127
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 105)
						(< (sewer prevDistance:) 40)
					)
					(gLongSong2 play:)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: -39 125
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 110)
				else
					(gLongSong2 fade:)
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

(instance enterRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					hide:
					posn: 309 134
					setMotion: MoveTo 290 134 self
				)
				(if (and (== (sewer status:) 3) (== (sewer location:) 110))
					(gLongSong2 play:)
					(if (> (sewer oldDistance:) 100)
						(sewer oldDistance: 100)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: (- 320 (sewer oldDistance:)) 125
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 115)
						(< (sewer prevDistance:) 40)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 359 125
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 110)
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

