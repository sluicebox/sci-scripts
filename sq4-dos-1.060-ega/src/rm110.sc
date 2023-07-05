;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use sewer)
(use eRS)
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
		(sewer roomVer: 22691)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(95
				(self setScript: enterNorth)
				(= temp0 42)
			)
			(east
				(= temp0 40)
				(HandsOff)
				(self setScript: enterRight)
			)
			(west
				(if (== (sewer location:) 90)
					(sewer status: 0 location: 0)
				)
				(= temp0 41)
				(HandsOff)
				(self setScript: enterLeft)
			)
			(else
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo init: hide: posn: 20 133)
				(NormalEgo)
			)
		)
		(self style: temp0)
		((ScriptID 702 5) ; theDrip1
			init:
			setLoop: 13
			posn: 250 114
			setScript: daDripScript
		)
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
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitScript)
			)
			((or (== (gEgo edgeHit:) 4) (== (gEgo edgeHit:) 2))
				(if (== (sewer location:) 95)
					(sewer status: 0 location: 0)
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
			((and (== (sewer location:) 95) (> (sewer rmTimer:) 6))
				(sewer status: 0 location: 0)
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
				moveSpeed: 0
				posn: 346 125
				setCycle: Fwd
				cycleSpeed: 0
				setScript: (ScriptID 702 4) ; theSlimeScript
			)
			(gLongSong2 vol: 127 playBed:)
			(gLongSong vol: 0 fade: 0 10 10 0)
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
				moveSpeed: 0
				posn: -39 125
				setCycle: Fwd
				cycleSpeed: 0
				setScript: (ScriptID 702 4) ; theSlimeScript
			)
			(gLongSong2 vol: 127 playBed:)
			(gLongSong vol: 0 fade: 0 10 10 0)
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
					(sewer location: 95)
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
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
					(if
						(and
							(or
								(< ((ScriptID 702 2) x:) 90) ; theSlime
								(> ((ScriptID 702 2) x:) 240) ; theSlime
							)
							(== ((ScriptID 702 2) loop:) 2) ; theSlime
						)
						(sewer location: 0 status: 0)
					)
				)
				(if (== (sewer location:) 115)
					(sewer status: 0 location: 0)
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
				(cond
					((and (== (sewer status:) 6) (== (sewer location:) 110))
						(Load rsSOUND 818)
						(Load rsVIEW 76)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: 57 127
							moveSpeed: 0
							setLoop: 2
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(sewer status: 4)
					)
					((and (== (sewer status:) 3) (== (sewer location:) 110))
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
						(if (> (sewer oldDistance:) 109)
							(sewer oldDistance: 109)
						)
						((ScriptID 702 2) init: hide: moveSpeed: 0 setLoop: 2) ; theSlime
						(sewer status: 4)
						(if (not (Random 0 2))
							((ScriptID 702 2) ; theSlime
								posn: (sewer oldDistance:) 127
								setScript: (ScriptID 702 4) ; theSlimeScript
							)
						else
							((ScriptID 702 2) ; theSlime
								posn: (Random 310 334) 127
								setScript: slimeLeavingR
							)
						)
					)
					(
						(and
							(== (sewer status:) 3)
							(== (sewer location:) 105)
							(< (sewer prevDistance:) 40)
						)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: -39 125
							setLoop: 2
							moveSpeed: 0
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(sewer location: 110)
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
					setMotion: MoveTo 297 134 self
				)
				(if (and (== (sewer status:) 3) (== (sewer location:) 110))
					(gLongSong2 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						moveSpeed: 0
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer status: 4)
					(if (not (Random 0 2))
						((ScriptID 702 2) ; theSlime
							posn: (- 320 (sewer oldDistance:)) 125
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
					else
						((ScriptID 702 2) ; theSlime
							posn: (Random -21 12) 127
							setScript: slimeLeavingL
						)
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
						moveSpeed: 0
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

(instance enterNorth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(sewer rmTimer: 0)
				(gEgo init: posn: 161 76)
				(if (== (sewer status:) 3)
					(switch (sewer location:)
						(95
							(if (< (sewer prevDistance:) 60)
								(sewer prevDistance: 60)
							)
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
				(= seconds 2)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(sewer rmTimer: 0)
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
				(sewer status: 8)
				((ScriptID 702 2) setCycle: Fwd setMotion: MoveTo 370 127 self) ; theSlime
			)
			(1
				((ScriptID 702 2) dispose:) ; theSlime
				(sewer location: 115 status: 6)
			)
		)
	)
)

(instance slimeLeavingL of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(sewer status: 8)
				((ScriptID 702 2) setCycle: Fwd setMotion: MoveTo -45 127 self) ; theSlime
			)
			(1
				((ScriptID 702 2) dispose:) ; theSlime
				(sewer location: 105 status: 6)
			)
		)
	)
)

(instance daDripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 5) setCycle: End self) ; theDrip1
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

