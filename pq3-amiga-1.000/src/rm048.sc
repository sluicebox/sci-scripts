;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm048 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11 = 1
	local12 = 1
	local13
	local14
	local15
	local16
	local17
	local18 = 1000
	local19
	[local20 14] = [0 0 124 90 117 92 110 94 103 96 97 97 -1 -1]
	[local34 26] = [0 0 109 107 115 106 119 103 124 99 129 95 134 91 138 87 131 86 124 85 116 84 109 83 -1 -1]
	[local60 20] = [0 0 106 105 111 104 117 103 123 102 133 100 138 99 143 98 148 97 -1 -1]
)

(procedure (localproc_0 param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(procedure (localproc_1)
	(= local0 10000)
	(= local2 0)
	(patron2 setScript: 0)
	(bartender setCycle: 0 loop: 6 cel: 0 signal: (| (bartender signal:) $1800))
	(poolPlayer
		setCycle: 0
		loop: 1
		cel: 0
		signal: (| (poolPlayer signal:) $1800) 150 End
	)
	(patron1 setCycle: 0 loop: 6 cel: 0)
	(patron2 setCycle: 0 loop: 7 cel: 0)
)

(procedure (localproc_2)
	(= local0 10000)
	(bartender loop: 6 cel: 1 signal: (| (bartender signal:) $1800))
	(patron1 loop: 6 cel: 1)
	(patron2 loop: 7 cel: 1)
)

(instance rm048 of PQRoom
	(properties
		lookStr {The place has a lot of atmosphere... "cough, cough."}
		picture 48
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 272 189 246 164 232 158 182 114 91 138 0 134 0 0 319 0 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 241 189 40 189 100 145 119 145 135 164 151 164 138 150 138 140 161 132 179 136
					yourself:
				)
		)
		(LoadMany rsVIEW 511 512 517 513 518 519 4 20 355 510)
		(LoadMany rsSOUND 470 484 485 937)
		(switch gPrevRoomNum
			(47
				(pat init:)
				(gEgo
					view: 4
					loop: 9
					x: 285
					y: 221
					actions: egoActions
					init:
				)
				(HandsOff)
				(gCurRoom setScript: sEnterBar)
			)
			(else
				(gEgo
					view: 4
					loop: 9
					x: 285
					y: 221
					actions: egoActions
					init:
				)
				(gLongSong number: 470 vol: 127 flags: 1 loop: -1 play:)
				(pat init:)
				(HandsOff)
				(gCurRoom setScript: sEnterBar)
			)
		)
		(poolPlayer init: approachVerbs: 3 4 5) ; Do, Inventory, Talk
		(patron1 init: approachVerbs: 3 4 5) ; Do, Inventory, Talk
		(patron2 init: approachVerbs: 3 4 5) ; Do, Inventory, Talk
		(bartender init: approachVerbs: 3 4 5) ; Do, Inventory, Talk
		(poolCue init:)
		(tv init: setCycle: Fwd)
		(poolBalls init:)
		(cueBall_a init:)
		(poolPlayer setScript: sShootPool)
		(poolTable init:)
		(billiardsLight init:)
		(boose init:)
		(bar init:)
		(tables init:)
		(greaseBoard init:)
		(poolCues init:)
		(tvFeature init:)
		(= local18 (* (+ 1 gHowFast) 300))
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (> local0 0) (== local1 0))
			(-- local0)
		else
			(= local0 (Random 100 1000))
		)
		(cond
			((> local18 0)
				(-- local18)
			)
			((and (!= (rocklin script:) sRocklinPlayPool) (== local18 0))
				(= local18 -1)
				(rocklin init: setScript: sRocklinPlayPool)
			)
		)
		(cond
			((and (<= (gEgo x:) (+ (rocklin x:) 15)) (!= local16 0))
				(= local16 0)
			)
			((and (> (gEgo x:) (+ (rocklin x:) 15)) (!= local16 1))
				(= local16 1)
			)
		)
		(cond
			(script)
			((localproc_0 gEgo 128)
				(HandsOff)
				(gCurRoom setScript: sLeaveBar)
			)
			((localproc_0 gEgo 2)
				(HandsOff)
				(gCurRoom setScript: sEgoWalkOffScreen)
			)
		)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(if (== local13 1)
							((gTheIconBar at: 4) cursor: 50)
							((gInventory at: 1) cursor: 50) ; gun
							(gGame setCursor: 50)
							(User canControl: 0)
							(gTheIconBar disable: 0)
							(gEgo
								normal: 0
								view: 519
								loop: local16
								cel: 0
								signal: (| (gEgo signal:) $1800)
								setCycle: CT 8 1
							)
							(= local17 8)
						else
							(Print 48 0) ; "Better keep it holstered until you REALLY need it."
						)
					)
				)
			)
		)
	)
)

(instance sEgoWalkOffScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 43 (gEgo y:) self)
			)
			(1
				(Print 48 1) ; "Hmmm... nothing of interest back here."
				(= ticks 1)
			)
			(2
				(gEgo setMotion: PolyPath 69 159 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sEnterBar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gLongSong setVol: 127)
				(pat setCycle: Walk setMotion: PolyPath 208 158 self)
				(gEgo setCycle: Walk setMotion: PolyPath 236 164 self)
			)
			(2
				(pat view: 355 loop: 7 signal: (| (pat signal:) $0800))
			)
			(3
				(pat loop: 0 signal: (| (pat signal:) $0800))
				(= seconds 2)
			)
			(4
				(= save1 1)
				(pInset init:)
				(Say pInset 48 2) ; "I'm gonna check out the back for the suspect, Sonny."
				(= seconds 4)
			)
			(5
				(pInset dispose:)
				(pat
					view: 20
					setCycle: Walk
					signal: (& (pat signal:) $f7ff)
					setMotion: PolyPath 24 135 self
				)
			)
			(6
				(UnLoad 128 20)
				(UnLoad 128 355)
				(pat dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Walk setMotion: PolyPath 270 215 self)
			)
			(1
				(gCurRoom newRoom: 47)
			)
		)
	)
)

(instance sShootPool of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poolBalls hide:)
				(poolPlayer setCycle: End self)
			)
			(1
				(poolPlayer cel: 7 signal: (| (poolPlayer signal:) $1000))
				(self cue:)
			)
			(2
				(poolPlayer
					cel: 6
					signal: (| (poolPlayer signal:) $1000)
					setCycle: Beg self
				)
				(poolBalls show:)
			)
			(3
				(poolPlayer
					loop: 1
					cel: 3
					x: 80
					y: 128
					signal: (| (poolPlayer signal:) $1800)
					setCycle: End self
				)
				(poolCue dispose:)
			)
			(4
				(poolPlayer
					loop: 2
					cel: 0
					setCycle: Walk
					signal: (| (poolPlayer signal:) $0800)
					setMotion: MoveTo 98 144 self
				)
			)
			(5
				(poolPlayer
					loop: 3
					cel: 0
					setCycle: Walk
					signal: (| (poolPlayer signal:) $4800)
					setMotion: MoveTo 171 115 self
				)
			)
			(6
				(poolPlayer
					loop: 4
					cel: 0
					setCycle: Walk
					signal: (| (poolPlayer signal:) $0800)
					setMotion: MoveTo 167 94 self
				)
			)
			(7
				(poolPlayer
					loop: 5
					cel: 0
					x: 151
					y: 96
					signal: (| (poolPlayer signal:) $1800)
				)
				(= seconds 5)
			)
			(8
				(poolPlayer setCycle: CT 5 1)
				(= seconds 5)
			)
			(9
				(poolPlayer setCycle: CT 7 1 self)
			)
			(10
				(if (== [local20 local19] 0)
					(poolPlayer setCycle: End)
					(roomSFX number: 485 play:)
				)
				(if (!= [local20 (+= local19 2)] -1)
					(-- state)
					(cueBall_a x: [local20 local19] y: [local20 (+ local19 1)])
				)
				(= cycles 2)
			)
			(11
				(= local19 0)
				(roomSFX number: 484 play:)
				(cueBall_a
					loop: 1
					priority: 9
					signal: (| (cueBall_a signal:) $0810)
					setMotion: MoveTo 93 95
				)
				(poolBalls setCycle: CT 11 1 self)
			)
			(12
				(ball1 init:)
				(ball2 init:)
				(ball3 init:)
				(poolBalls cel: 12 signal: (| (poolBalls signal:) $1000))
				(self cue:)
			)
			(13
				(poolPlayer
					view: 518
					loop: 0
					cel: 0
					x: 163
					y: 94
					signal: (| (poolPlayer signal:) $1800)
					setCycle: End self
				)
			)
			(14
				(UnLoad 128 510)
				(= local0 150)
				(= local9 1)
				(self dispose:)
			)
		)
	)
)

(instance sRocklinPlayPool of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (not state) (>= (gEgo x:) 170))
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 508 509 514)
			)
			(1
				(rocklin
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 80 128 self
				)
			)
			(2
				(rocklin
					view: 509
					loop: 2
					cel: 0
					signal: (| (rocklin signal:) $1800)
				)
				(= seconds 3)
			)
			(3
				(rocklin view: 509 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(if (== local10 1)
					(= local10 0)
					(HandsOff)
					(self setScript: sRocklinInset self)
				else
					(= ticks 1)
				)
			)
			(5
				(= local11 2)
				(= seconds 2)
			)
			(6
				(rocklin setCycle: End self)
			)
			(7
				(if (== [local34 local19] 0)
					(roomSFX number: 485 play:)
					(rocklin setCycle: Beg)
				)
				(if (!= [local34 (+= local19 2)] -1)
					(-- state)
					(ball2 x: [local34 local19] y: [local34 (+ local19 1)])
				)
				(= cycles 2)
			)
			(8
				(ball2 dispose:)
				(= local19 0)
				(rocklin
					view: 508
					loop: 3
					cel: 0
					setCycle: Walk
					signal: (| (rocklin signal:) $1800)
					setMotion: MoveTo 77 126 self
				)
			)
			(9
				(rocklin
					view: 509
					loop: 2
					cel: 0
					signal: (| (rocklin signal:) $1800)
				)
				(= seconds 3)
			)
			(10
				(rocklin
					view: 509
					loop: 2
					cel: 0
					signal: (| (rocklin signal:) $1800)
					setCycle: CT 2 1 self
				)
			)
			(11
				(if (== local10 1)
					(= local10 0)
					(HandsOff)
					(self setScript: sRocklinInset self)
				else
					(= ticks 1)
				)
			)
			(12
				(= local11 3)
				(= seconds 2)
			)
			(13
				(rocklin setCycle: End self)
			)
			(14
				(if (== [local60 local19] 0)
					(roomSFX number: 485 play:)
					(rocklin setCycle: Beg)
				)
				(if (!= [local60 (+= local19 2)] -1)
					(-- state)
					(ball3 x: [local60 local19] y: [local60 (+ local19 1)])
				)
				(= cycles 2)
			)
			(15
				(ball3 dispose:)
				(= local19 0)
				(= cycles 3)
			)
			(16
				(rocklin
					view: 508
					loop: 3
					setCycle: Walk
					signal: (| (rocklin signal:) $4800)
					setMotion: MoveTo 52 98 self
				)
			)
			(17
				(rocklin
					loop: 0
					signal: (| (rocklin signal:) $0800)
					setMotion: MoveTo 82 97 self
				)
				(= local13 1)
			)
			(18
				(= local12 1)
				(= local14 1)
				(rocklin
					view: 514
					loop: 0
					cel: 0
					signal: (| (rocklin signal:) $1800)
				)
				(= seconds 4)
			)
			(19
				(rocklin
					priority: 13
					signal: (| (rocklin signal:) $0010)
					setCycle: End self
				)
				(if (== local10 1)
					(= local12 0)
				)
			)
			(20
				(if (== local10 1)
					(HandsOff)
					(gLongSong fade:)
					(self setScript: sRocklinInset self)
				else
					(= ticks 1)
				)
			)
			(21
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 1)) ; gun
					(rocklin
						view: 514
						loop: 2
						signal: (| (rocklin signal:) $0800)
						setCycle: CT 8 1 self
					)
				else
					(rocklin view: 514 loop: 1 setCycle: CT 10 1 self)
				)
			)
			(22
				(roomSFX number: 937 play:)
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 1)) ; gun
					(= local14 0)
					(gLongSong number: 460 vol: 127 flags: 1 loop: -1 play:)
					(= cycles 1)
				else
					(gEgo
						setMotion: 0
						normal: 0
						view: 14
						cel: 0
						signal: (| (gEgo signal:) $1000)
						setCycle: End self
					)
				)
			)
			(23
				(localproc_1)
				(rocklin loop: 2 cel: 8 setCycle: End self)
			)
			(24
				(if (== (gEgo view:) 14)
					(EgoDead 27) ; "You think about Marie as the bullet rips through your chest."
				else
					(SetScore 167 5)
					(= seconds 2)
				)
			)
			(25
				(localproc_2)
				(rocklin dispose:)
				(SetFlag 51)
				(gCurRoom newRoom: 47)
			)
		)
	)
)

(instance sRocklinInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= local11 2)
					(rocklinInset init: cel: 0 setCycle: End self)
				else
					(rocklinInset init: cel: 0)
					(= seconds 1)
				)
				(= local10 0)
			)
			(1
				(if (== local11 3)
					(insetFace init: cel: 0 setCycle: End)
					(= seconds 3)
				else
					(= ticks 1)
				)
			)
			(2
				(switch local11
					(1
						(Print 48 3) ; "Hey that guy kinda looks familiar."
					)
					(2
						(Print 48 4) ; "The punk's hateful glare burns right through you."
					)
					(3
						(Print 48 5) ; "You look carefully at the man. He closely matches the bag lady's physical description of the suspect in Marie's stabbing."
					)
				)
				(= ticks 1)
			)
			(3
				(rocklinInset dispose:)
				(insetFace dispose:)
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance sShootRocklin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo
					normal: 0
					view: 519
					loop: local16
					cel: local17
					setCycle: CT 9 1 self
				)
			)
			(2
				(gEgo setCycle: End)
				(if (== local14 1)
					(sRocklinPlayPool dispose:)
					(rocklin
						view: 514
						loop: 3
						setPri: 6
						cel: local17
						setCycle: End
					)
				)
				(roomSFX number: 937 play:)
				(= cycles 1)
			)
			(3
				(localproc_1)
				(= seconds 1)
			)
			(4
				(localproc_2)
				(= seconds 2)
			)
			(5
				(if (== (rocklin loop:) 3)
					(EgoDead 26) ; "You shot the suspect without probable cause. Based on the damning testimony of the witnesses you are convicted and sent to jail, where you meet an obese inmate named Popeye who makes you his "special friend"."
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTurnTvOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bartender
					loop: 3
					cel: 0
					signal: (| (bartender signal:) $1800)
					setCycle: CT 4 1 self
				)
			)
			(1
				(tv dispose:)
				(= local15 1)
				(self cue:)
			)
			(2
				(bartender setCycle: End self)
			)
			(3
				(bartender loop: 4 cel: 3 signal: (| (bartender signal:) $1800))
				(self cue:)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sBarTender of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== (bartender y:) local4) (== (bartender x:) local3)) 0)
					((>= (bartender y:) local4)
						(bartender
							view: 511
							loop: 1
							signal: (| (bartender signal:) $0800)
						)
					)
					((< (bartender y:) local4)
						(bartender
							view: 511
							loop: 0
							signal: (| (bartender signal:) $0800)
						)
					)
				)
				(self cue:)
			)
			(1
				(if (and (== (bartender y:) local4) (== (bartender x:) local3))
					(self cue:)
				else
					(bartender
						setCycle: Walk
						setMotion: MoveTo local3 local4 self
					)
				)
			)
			(2
				(if (< (bartender y:) 128)
					(bartender
						view: 517
						loop: 0
						cel: 0
						signal: (| (bartender signal:) $1800)
						setCycle: Fwd
					)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(3
				(bartender
					view: 517
					loop: local5
					cel: 0
					signal: (| (bartender signal:) $1800)
					setCycle: End self
				)
			)
			(4
				(if (>= (bartender y:) local4)
					(bartender
						view: 511
						loop: 1
						signal: (| (bartender signal:) $0800)
					)
				else
					(bartender
						view: 511
						loop: 0
						signal: (| (bartender signal:) $0800)
					)
				)
				(self cue:)
			)
			(5
				(bartender setCycle: Walk setMotion: MoveTo 196 78 self)
			)
			(6
				(bartender
					view: 517
					loop: 4
					cel: 0
					signal: (| (bartender signal:) $1800)
					setCycle: End self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sBarPatron of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 (Random 3 6))
				(patron2 loop: 2 cel: 0 setCycle: End)
				(= seconds 5)
			)
			(1
				(= start state)
				(patron2 loop: 3 cel: 0 setCycle: CT 3 1)
				(= seconds 3)
			)
			(2
				(patron2 setCycle: End)
				(= seconds 5)
			)
			(3
				(if (== local2 0)
					(= start 0)
					(self dispose:)
				else
					(-- local2)
					(self init:)
				)
			)
		)
	)
)

(instance roomSFX of Sound
	(properties
		flags 1
	)
)

(instance pat of Actor
	(properties
		x 250
		y 190
		yStep 3
		view 20
		loop 1
		xStep 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rocklin of Actor
	(properties
		x 33
		y 136
		description {the man}
		sightAngle 40
		view 508
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(if (and (<= (rocklin y:) 98) (== local12 1))
							(HandsOff)
							(gCurRoom setScript: sShootRocklin)
						else
							(Print 48 0) ; "Better keep it holstered until you REALLY need it."
						)
					)
				)
			)
			(2 ; Look
				(if (== local11 1)
					(Print 48 6) ; "As you turn to ask the pool player about the vehicle..."
				)
				(Face gEgo rocklin)
				(= local10 1)
			)
			(5 ; Talk
				(if (== local11 1)
					(Print 48 6) ; "As you turn to ask the pool player about the vehicle..."
				)
				(Face gEgo rocklin)
				(= local10 1)
			)
			(3 ; Do
				(if (<= local11 2)
					(Print 48 7) ; "If you want something from the man why don't you just ask."
				else
					(Print 48 8) ; "Approaching a potentially armed suspect, unprepared is not advisable."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bartender of Actor
	(properties
		x 196
		y 78
		description {the bartender}
		sightAngle 40
		approachX 200
		approachY 132
		lookStr {The bartender is a tough-looking woman. She's sporting a " Peterbilt" T-shirt and a "don't mess with me" grimace. She looks as though she's perfectly capable of keeping her customers in line.}
		view 517
		loop 4
		signal 16384
		cycleSpeed 8
		moveSpeed 8
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((== local0 925)
				(= local5 1)
				(= local3 254)
				(= local4 128)
				(self setScript: sBarTender)
			)
			((== local0 825)
				(= local5 1)
				(= local3 219)
				(= local4 96)
				(self setScript: sBarTender)
			)
			((== local0 100)
				(if (> (bartender cel:) 0)
					(self
						loop: 4
						signal: (| (bartender signal:) $0800)
						setCycle: Beg self
					)
				else
					(self
						loop: 4
						signal: (| (bartender signal:) $0800)
						setCycle: End self
					)
				)
			)
			((and (== local15 0) (== local0 500))
				(self setScript: sTurnTvOff)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(= local1 1)
				(= local0 1000)
				(cond
					((!= (bartender mover:) 0)
						(Print 48 9) ; "Maybe I'd have better luck getting her attention when she isn't quite so busy."
					)
					((!= (bartender cycler:) 0)
						(Print 48 9) ; "Maybe I'd have better luck getting her attention when she isn't quite so busy."
					)
					((== local6 0)
						(HandsOff)
						(= local6 1)
						(bartender setScript: sBartenderTalk1)
					)
					((== local6 1)
						(HandsOff)
						(= local6 2)
						(bartender setScript: sBartenderTalk2)
					)
					((== local6 2)
						(HandsOff)
						(bartender setScript: sBartenderTalk3)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sBartenderTalk1 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say gEgo 48 10) ; "You know anything about that car parked out front?"
				(= seconds 4)
			)
			(1
				(= save1 1)
				(Say bartender 48 11) ; "My customer's cars are their own business."
				(= seconds 4)
			)
			(2
				(= save1 1)
				(Say gEgo 48 12) ; "Okay, thanks."
				(= seconds 3)
			)
			(3
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBartenderTalk2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say bartender 48 13) ; "What can I do for ya tonight?"
				(= seconds 4)
			)
			(1
				(= save1 1)
				(Say gEgo 48 14) ; "Nothing. Thanks."
				(= seconds 4)
			)
			(2
				(= save1 1)
				(Say bartender 48 15) ; "Hey pal! If yer not buyin' booze, yer just takin' up real estate!"
				(= seconds 3)
			)
			(3
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBartenderTalk3 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say bartender 48 16) ; "If you wanna order a drink then order it."
				(= seconds 4)
			)
			(1
				(= save1 1)
				(Say bartender 48 17) ; "I ain't got time for idle chit chat right now!"
				(= seconds 4)
			)
			(2
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance poolPlayer of Actor
	(properties
		x 81
		y 128
		description {the pool player}
		sightAngle 40
		approachX 165
		approachY 119
		view 510
		cel 7
		priority 8
		signal 16
		cycleSpeed 8
		moveSpeed 8
	)

	(method (cue)
		(poolPlayer setCycle: 0)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((and (== (poolPlayer view:) 518) (== local0 0))
				(if (== (poolPlayer cel:) 0)
					(poolPlayer setCycle: End self)
				else
					(poolPlayer setCycle: Beg self)
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 48 18) ; "The man playing pool hasn't done anything wrong, except be rude."
					)
				)
			)
			(2 ; Look
				(if (< local18 0)
					(Print 48 19) ; "He's waiting for his pool partner to finish his turn."
				else
					(Print 48 20) ; "The man playing pool looks like a rough customer. You wonder where his pool partner is."
				)
			)
			(5 ; Talk
				(cond
					((== local9 0)
						(Print 48 21) ; "Maybe you should wait until he makes his shot first."
					)
					((== local9 1)
						(HandsOff)
						(poolPlayer setScript: sTalkToPlayer)
						(= local9 2)
					)
					((== local9 2)
						(Print 48 22) ; "The man ignores you. He seems to be waiting on someone to come finish the game."
					)
				)
			)
			(3 ; Do
				(if (== local9 1)
					(Print 48 23) ; "You think about busting the guy's head, but you restrain yourself."
				else
					(Print 48 7) ; "If you want something from the man why don't you just ask."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sTalkToPlayer of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say gEgo 48 24) ; "Is that your car out front?"
				(= seconds 4)
			)
			(1
				(= save1 1)
				(Say poolPlayer 48 25) ; "*Sniff* Anybody else in here smell bacon?"
				(= seconds 3)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cueBall_a of Actor
	(properties
		name {cueBall}
		x 131
		y 87
		description {the cue ball}
		view 513
		loop 1
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pInset of Prop
	(properties
		x 142
		y 126
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(pShirt x: (+ (self x:) 2) y: (+ (self y:) 62) init:)
		(self signal: (| (pInset signal:) $0001))
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(pMouth dispose:)
		(pShirt dispose:)
	)
)

(instance pMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance pShirt of View
	(properties
		description {pat}
		view 27
		cel 1
		priority 15
		signal 16401
	)
)

(instance patron1 of Prop
	(properties
		x 188
		y 94
		description {the man at the bar}
		sightAngle 40
		approachX 200
		approachY 132
		lookStr {Just a skinny lil' guy minding his own business.}
		view 512
		priority 7
		signal 16
		cycleSpeed 8
	)

	(method (cue)
		(patron1 setCycle: 0)
	)

	(method (doit)
		(super doit: &rest)
		(if (== local0 300)
			(self setCycle: Beg self)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 48 26) ; "Why on earth would you want to do that?!"
					)
				)
			)
			(5 ; Talk
				(switch (++ local7)
					(1
						(HandsOff)
						(patron1 setScript: sPatron1Talks)
					)
					(else
						(Print 48 27) ; "He seems harmless enough. You decide to leave him alone."
					)
				)
			)
			(3 ; Do
				(Print 48 28) ; "The guy hasn't done anything wrong."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sPatron1Talks of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say gEgo 48 29) ; "Excuse me, Sir. is that your car parked right out front?"
				(= seconds 5)
			)
			(1
				(= save1 1)
				(Say patron1 48 30) ; "Naw! My car's been in the shop all week. Why?"
				(= seconds 4)
			)
			(2
				(= save1 1)
				(Say gEgo 48 31) ; "Nothing. thanks."
				(= seconds 2)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance patron2 of Prop
	(properties
		x 226
		y 132
		description {the man at the bar}
		sightAngle 40
		approachX 228
		approachY 155
		lookStr {This guy looks like he sprouted out of that bar stool. Must be a regular here.}
		view 512
		loop 1
		priority 9
		signal 16
		cycleSpeed 8
	)

	(method (cue)
		(patron2 setCycle: 0)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((== local0 700)
				(self setScript: sBarPatron)
			)
			((== local0 500)
				(self
					loop: 1
					cel: 0
					signal: (| (patron2 signal:) $1800)
					setCycle: Beg self
				)
			)
			((== local0 150)
				(self
					loop: 4
					cel: 0
					signal: (| (patron2 signal:) $1800)
					setCycle: Beg self
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 48 26) ; "Why on earth would you want to do that?!"
					)
				)
			)
			(5 ; Talk
				(switch (++ local8)
					(1
						(HandsOff)
						(patron2 setScript: sPatron2Talks)
					)
					(else
						(Print 48 32) ; "The guy's busy drowning his sorrows and doesn't pay any attention to you."
					)
				)
			)
			(3 ; Do
				(Print 48 33) ; "He hasn't done anything wrong. Leave him alone."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sPatron2Talks of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Say gEgo 48 34) ; "Excuse me sir, is that your car parked right out front?"
				(= seconds 4)
			)
			(1
				(= save1 1)
				(Say patron2 48 35) ; "Not me. I drive a Harley man!"
				(= seconds 4)
			)
			(2
				(= save1 1)
				(Say gEgo 48 36) ; "Sorry to bother you."
				(= seconds 4)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rocklinInset of Prop
	(properties
		x 16
		y 37
		description {the suspect}
		sightAngle 180
		lookStr {Hmm... sure matches the description.}
		view 515
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance insetFace of Prop
	(properties
		x 45
		y 73
		description {the suspect}
		sightAngle 180
		lookStr {Hmm... sure matches the description.}
		view 515
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance spill of Prop ; UNUSED
	(properties
		x 243
		y 111
		view 511
		loop 4
	)
)

(instance tv of Prop
	(properties
		x 167
		y 43
		description {the T.V.}
		sightAngle 40
		lookStr {Hmm.. might be an interesting program if it would stop flipping like that.}
		view 513
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poolBalls of Prop
	(properties
		x 96
		y 97
		description {the pool balls}
		lookStr {"Whoa! Nice set of balls!"}
		view 513
		loop 2
		priority 7
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poolCue of View
	(properties
		x 93
		y 127
		description {the pool cue}
		lookStr {It is a pool cue.}
		view 510
		loop 7
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cueBall_b of View ; UNUSED
	(properties
		name {cueBall}
		x 131
		y 87
		description {the cue ball}
		view 513
		loop 1
		priority 9
		signal 16400
	)
)

(instance ball1 of View
	(properties
		x 111
		y 105
		view 513
		loop 5
		priority 9
		signal 16400
	)
)

(instance ball2 of View
	(properties
		x 103
		y 108
		view 513
		loop 4
		priority 9
		signal 16400
	)
)

(instance ball3 of View
	(properties
		x 100
		y 106
		view 513
		loop 3
		priority 9
		signal 16400
	)
)

(instance poolTable of Feature
	(properties
		description {the pool table}
		onMeCheck 16
		lookStr {There's a pool table at one end of the bar room - a staple of American neighborhood juice joints.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 37) ; "Touching the pool table while someone is playing isn't a good idea."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance billiardsLight of Feature
	(properties
		description {the light}
		onMeCheck 32
		lookStr {The lamp over the pool table gives off a sickly glare.}
	)
)

(instance boose of Feature
	(properties
		description {the liquor}
		onMeCheck 1024
		lookStr {The bartender's arsenal of poisons is neatly arranged behind her.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 38) ; "If you want a drink just order one."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bar of Feature
	(properties
		description {the bar}
		onMeCheck 512
		lookStr {The bar's worn and waxed wooden surface has obviously seen a lot of action.}
	)
)

(instance tables of Feature
	(properties
		description {the tables}
		onMeCheck 256
		lookStr {Empty tables and chairs sit silently about, waiting for a crowd to arrive.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 39) ; "You don't have time to sit down."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance greaseBoard of Feature
	(properties
		description {the score board}
		onMeCheck 64
		lookStr {You see various scores of past games.}
	)
)

(instance poolCues of Feature
	(properties
		description {the pool cues}
		onMeCheck 8
		lookStr {Those cues look pretty beat up, probably get a sliver from one of them.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 40) ; "Ahh... if you only had time!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tvFeature of Feature
	(properties
		description {the T.V.}
		onMeCheck 4
		lookStr {Looks like someone used the screen for a spitting contest target.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 41) ; "You don't have time to watch television."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance barStools of Feature ; UNUSED
	(properties
		description {the barstools}
		onMeCheck 2048
		lookStr {The barstool's leather tops have been worn smooth by countless rear ends.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 39) ; "You don't have time to sit down."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance candles of Feature ; UNUSED
	(properties
		description {the candles}
		onMeCheck 4096
		lookStr {Seventies-style glass candle-holders attempt to soften the atmosphere.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 42) ; "You wouldn't take one of those tacky candles if somebody paid you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ashtrays of Feature ; UNUSED
	(properties
		description {the ashtrays}
		onMeCheck 8192
		lookStr {As in most bars, ashtrays are everywhere. You try to ignore their contents.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 48 43) ; "No thanks, you don't smoke."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

