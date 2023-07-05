;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 750)
(include sci.sh)
(use Main)
(use n013)
(use moveBushes)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	sweepRgn 0
	proc750_1 1
	proc750_2 2
	proc750_3 3
)

(local
	[local0 4]
	local4
	[local5 12]
	[local17 9]
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	[local34 4] = [1750 0 1 0]
	[local38 5] = [1750 1 1 1 0]
	[local43 5] = [1750 5 1 2 0]
	[local48 4] = [1750 5 1 0]
	[local52 4] = [1750 21 1 0]
	[local56 20] = [1750 22 1 0 1750 28 1 0 1750 42 1 0 1750 44 1 0 1750 46 1 0]
	[local76 10] = [1750 34 2 1 2 1 2 1 2 0]
	[local86 9] = [1750 48 3 1 2 2 3 3 0]
	[local95 8] = [1750 54 1 3 1 3 2 0]
	[local103 7] = [1750 23 2 1 3 3 0]
	[local110 15] = [1750 7 1 2 3 2 3 1 3 0 1750 29 1 1 0]
	[local125 6] = [1750 31 1 2 3 0]
	[local131 9] = [-1 {Jack} 19 0 0 0 0 0 0]
	[local140 40] = [0 100 66 100 0 90 66 90 0 100 66 100 110 85 110 100 0 92 66 93 0 179 28 179 280 81 280 245 40 245 40 82 -20 100 330 100 330 100 -20 100]
	[local180 40] = [0 185 50 170 0 85 50 95 0 185 50 170 320 85 275 100 0 185 60 171 160 270 160 210 160 81 160 245 160 245 160 81 -20 135 330 135 330 135 -20 135]
	[local220 44] = [320 135 295 142 320 100 295 102 200 245 165 185 320 135 275 140 320 150 295 142 330 175 295 175 40 79 40 245 280 245 280 79 -30 180 330 180 330 180 -20 180 0 179 330 179]
	local264
	local265
	local266
	local267
	local268
)

(procedure (proc750_1 &tmp [temp0 2])
	(cond
		((== gCurRoomNum 180)
			(cond
				((== gEgoEdgeHit 3)
					(= gEgoEdgeHit 4)
				)
				((== gEgoEdgeHit 1)
					(= gEgoEdgeHit 2)
				)
				(else
					(= gEgoEdgeHit 2)
				)
			)
		)
		(
			(or
				(== gForestRoomNum 41)
				(== gForestRoomNum 73)
				(== gForestRoomNum 104)
				(== gForestRoomNum 151)
				(== gForestRoomNum 24)
				(== gForestRoomNum 149)
			)
			(= gEgoEdgeHit 2)
		)
		(
			(or
				(== gForestRoomNum 43)
				(== gForestRoomNum 75)
				(== gForestRoomNum 106)
				(== gForestRoomNum 153)
				(== gForestRoomNum 25)
				(== gForestRoomNum 166)
				(== gForestRoomNum 182)
				(== gForestRoomNum 150)
			)
			(= gEgoEdgeHit 4)
		)
		((or (== gForestRoomNum 90) (== gForestRoomNum 121) (== gForestRoomNum 168))
			(= gEgoEdgeHit 1)
		)
		(
			(or
				(== gForestRoomNum 89)
				(== gForestRoomNum 136)
				(== gForestRoomNum 36)
				(== gForestRoomNum 38)
				(== gForestRoomNum 69)
				(== gForestRoomNum 82)
				(== gForestRoomNum 100)
				(== gForestRoomNum 104)
				(== gForestRoomNum 130)
				(== gForestRoomNum 138)
				(== gForestRoomNum 37)
				(== gForestRoomNum 99)
				(== gForestRoomNum 135)
				(== gForestRoomNum 167)
				(== gForestRoomNum 3)
				(== gForestRoomNum 4)
				(== gForestRoomNum 5)
				(== gForestRoomNum 6)
				(== gForestRoomNum 24)
				(== gForestRoomNum 25)
				(== gForestRoomNum 26)
				(== gForestRoomNum 2)
				(== gForestRoomNum 17)
				(== gForestRoomNum 32)
				(== gForestRoomNum 7)
				(== gForestRoomNum 27)
				(== gForestRoomNum 60)
			)
			(= gEgoEdgeHit 3)
		)
		(
			(or
				(== gForestRoomNum 18)
				(== gForestRoomNum 68)
				(== gForestRoomNum 72)
				(== gForestRoomNum 98)
				(== gForestRoomNum 106)
				(== gForestRoomNum 116)
				(== gForestRoomNum 136)
				(== gForestRoomNum 51)
				(== gForestRoomNum 117)
				(== gForestRoomNum 147)
				(== gForestRoomNum 148)
				(== gForestRoomNum 149)
				(== gForestRoomNum 168)
				(== gForestRoomNum 169)
				(== gForestRoomNum 170)
				(== gForestRoomNum 182)
				(== gForestRoomNum 64)
				(== gForestRoomNum 129)
				(== gForestRoomNum 146)
				(== gForestRoomNum 76)
				(== gForestRoomNum 171)
				(== gForestRoomNum 183)
			)
			(= gEgoEdgeHit 1)
		)
		(
			(or
				(== gForestRoomNum 24)
				(== gForestRoomNum 39)
				(== gForestRoomNum 54)
				(== gForestRoomNum 70)
				(== gForestRoomNum 86)
				(== gForestRoomNum 101)
				(== gForestRoomNum 117)
				(== gForestRoomNum 133)
				(== gForestRoomNum 149)
				(== gForestRoomNum 21)
				(== gForestRoomNum 23)
				(== gForestRoomNum 35)
				(== gForestRoomNum 50)
				(== gForestRoomNum 54)
				(== gForestRoomNum 85)
				(== gForestRoomNum 86)
				(== gForestRoomNum 89)
				(== gForestRoomNum 115)
				(== gForestRoomNum 121)
				(== gForestRoomNum 133)
				(== gForestRoomNum 153)
				(== gForestRoomNum 101)
				(== gForestRoomNum 121)
				(== gForestRoomNum 137)
				(== gForestRoomNum 48)
				(== gForestRoomNum 81)
				(== gForestRoomNum 97)
				(== gForestRoomNum 113)
				(== gForestRoomNum 2)
				(== gForestRoomNum 17)
				(== gForestRoomNum 32)
				(== gForestRoomNum 64)
				(== gForestRoomNum 129)
				(== gForestRoomNum 146)
				(== gForestRoomNum 166)
				(== gForestRoomNum 182)
			)
			(= gEgoEdgeHit 2)
		)
		(
			(or
				(== gForestRoomNum 9)
				(== gForestRoomNum 25)
				(== gForestRoomNum 40)
				(== gForestRoomNum 55)
				(== gForestRoomNum 71)
				(== gForestRoomNum 87)
				(== gForestRoomNum 102)
				(== gForestRoomNum 118)
				(== gForestRoomNum 134)
				(== gForestRoomNum 150)
				(== gForestRoomNum 21)
				(== gForestRoomNum 23)
				(== gForestRoomNum 35)
				(== gForestRoomNum 50)
				(== gForestRoomNum 54)
				(== gForestRoomNum 85)
				(== gForestRoomNum 86)
				(== gForestRoomNum 89)
				(== gForestRoomNum 115)
				(== gForestRoomNum 121)
				(== gForestRoomNum 133)
				(== gForestRoomNum 153)
				(== gForestRoomNum 67)
				(== gForestRoomNum 43)
				(== gForestRoomNum 91)
				(== gForestRoomNum 107)
				(== gForestRoomNum 123)
				(== gForestRoomNum 139)
				(== gForestRoomNum 76)
				(== gForestRoomNum 171)
				(== gForestRoomNum 183)
				(== gForestRoomNum 7)
				(== gForestRoomNum 27)
				(== gForestRoomNum 60)
				(== gForestRoomNum 156)
			)
			(= gEgoEdgeHit 4)
		)
		(else
			(switch gEgoEdgeHit
				(1
					(= gEgoEdgeHit 3)
				)
				(3
					(= gEgoEdgeHit 1)
				)
				(4
					(= gEgoEdgeHit 2)
				)
				(2
					(= gEgoEdgeHit 4)
				)
			)
		)
	)
	(if (== gCurRoomNum 180)
		(= local264 40)
	else
		(switch gEgoEdgeHit
			(1
				(= local264 24)
			)
			(3
				(= local264 28)
			)
			(2
				(= local264 36)
			)
			(4
				(= local264 32)
			)
		)
	)
	(= local265 local264)
	(= local266 (+ local264 1))
	(= local267 (+ local264 2))
	(= local268 (+ local264 3))
	(if (== gCurRoomNum 220) ; forest
		((= [local17 0] (sherMan new:))
			posn: [local140 local265] [local140 local266]
			init:
			setMotion: PolyPath [local140 local267] [local140 local268] sherMan
		)
		((= [local17 1] (sherMan new:))
			posn: [local180 local265] [local180 local266]
			init:
			setMotion: PolyPath [local180 local267] [local180 local268] sherMan
		)
		((= [local17 2] (sherMan new:))
			posn: [local220 local265] [local220 local266]
			init:
			setMotion: PolyPath [local220 local267] [local220 local268] sherMan
		)
	else
		((= [local17 0] (sherMan new:))
			posn: [local220 local265] [local220 local266]
			init:
			setMotion: PolyPath [local220 local267] [local220 local268] sherMan
		)
	)
)

(procedure (proc750_2)
	(if (and (> gForestSweepRoomCount 2) (== gDisguiseNum 0)) ; outlaw
		(NormalEgo 0 3 1)
		(gEgoHead view: 1)
		(gEgo normal: 1 moveHead: 1 xStep: 8 yStep: 6)
	else
		(NormalEgo)
	)
	(switch gForestSweepRoomCount
		(0
			(++ gForestSweepRoomCount)
		)
		(1
			(++ gForestSweepRoomCount)
		)
		(2
			(++ gForestSweepRoomCount)
		)
		(3
			(gTheIconBar disable: 5)
			(if
				(or
					(and (not (IsFlag 36)) (== gDay 9))
					(and (not (IsFlag 38)) (== gDay 12))
				)
				(if
					(and
						(== gCurRoomNum 220) ; forest
						(or
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 54)
							(== gForestRoomNum 70)
							(== gForestRoomNum 86)
							(== gForestRoomNum 101)
							(== gForestRoomNum 117)
							(== gForestRoomNum 133)
							(== gForestRoomNum 149)
							(== gForestRoomNum 9)
							(== gForestRoomNum 25)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 71)
							(== gForestRoomNum 87)
							(== gForestRoomNum 102)
							(== gForestRoomNum 118)
							(== gForestRoomNum 134)
							(== gForestRoomNum 150)
							(== gForestRoomNum 26)
							(== gForestRoomNum 168)
							(== gForestRoomNum 58)
							(== gForestRoomNum 90)
							(== gForestRoomNum 121)
							(== gForestRoomNum 89)
							(== gForestRoomNum 136)
							(== gForestRoomNum 41)
							(== gForestRoomNum 73)
							(== gForestRoomNum 104)
							(== gForestRoomNum 151)
							(== gForestRoomNum 43)
							(== gForestRoomNum 75)
							(== gForestRoomNum 106)
							(== gForestRoomNum 153)
							(== gForestRoomNum 166)
							(== gForestRoomNum 182)
						)
					)
					(HandsOff)
				)
				(sweepRgn setScript: outlawSweep)
			)
		)
		(4
			(sweepRgn setScript: cleanSweep)
		)
		(5
			(sweepRgn setScript: cleanSweep)
		)
		(6
			(sweepRgn setScript: cleanSweep)
		)
		(7
			(sweepRgn setScript: surroundEgo)
		)
	)
)

(procedure (proc750_3 &tmp temp0)
	(sweepRgn setScript: 0)
	(if (gCast contains: local29)
		(local29 setMotion: 0 setCycle: 0 delete: dispose:)
	)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (gCast contains: [local17 temp0])
			([local17 temp0]
				setAvoider: 0
				setMotion: 0
				setCycle: 0
				delete:
				dispose:
			)
		)
	)
	(= local28 0)
	(= local29 0)
	(= [local17 0] 0)
	(= [local17 1] 0)
	(= [local17 2] 0)
)

(instance sweepRgn of Rgn
	(properties
		keep 1
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 220 180 210 250)) ; forest
			(self keep: 0)
		)
	)

	(method (init)
		(Load rsSCRIPT 928 930)
		(Load rsPIC 803)
		(LoadMany rsSOUND 400 25)
		(LoadMany rsVIEW 753 3 792 132 218 2 18 27 35 38 805)
		(switch gDisguiseNum
			(0 ; outlaw
				(= local4 1)
			)
			(4 ; yeoman
				(= local4 6)
			)
			(1 ; beggar
				(= local4 7)
			)
			(2 ; jewler (no rouge)
				(= local4 4)
			)
			(3 ; jewler (rouge)
				(= local4 5)
			)
			(5 ; abbey monk
				(= local4 9)
			)
			(6 ; fens monk
				(= local4 8)
			)
		)
		(super init:)
	)

	(method (doit &tmp temp0)
		(cond
			((and (IsFlag 115) (== local26 0))
				(= local26 1)
				(sweepRgn setScript: 0)
				((ScriptID 220 0) setScript: 0) ; forest
				(gEgo setScript: 0)
			)
			((IsFlag 110)
				(ClearFlag 110)
				(= local26 0)
				(handSignCode doit:)
			)
			((gEgo edgeHit:)
				(self setScript: 0)
			)
		)
		(super doit:)
	)

	(method (dispose &tmp temp0)
		(self setScript: 0)
		(ClearFlag 129)
		(gSFX stop:)
		(super dispose:)
	)
)

(instance sherPic of PicView ; UNUSED
	(properties)
)

(instance sherMan of Actor
	(properties)

	(method (cue)
		(++ local30)
		(cond
			((== gCurRoomNum 180)
				([local17 0] dispose:)
				(= [local17 0] 0)
				(if (and (< (gEgo view:) 238) (> (gEgo view:) 229))
					(gEgo setScript: (ScriptID 223 4)) ; unTreeEgo
				)
				(= local30 0)
			)
			((== local30 3)
				([local17 0] dispose:)
				([local17 1] dispose:)
				([local17 2] dispose:)
				(= [local17 0] 0)
				(= [local17 1] 0)
				(= [local17 2] 0)
				(if
					(or
						(and (< (gEgo view:) 238) (> (gEgo view:) 229))
						(& (gEgo signal:) $0080)
					)
					(gEgo setScript: (ScriptID 223 4)) ; unTreeEgo
				)
				(= local30 0)
			)
		)
		(super cue:)
	)

	(method (init)
		(self view: 753 signal: 24576 setCycle: StopWalk 754)
		(super init:)
	)

	(method (dispose)
		(= local28 0)
		(super dispose:)
	)

	(method (doit &tmp [temp0 2])
		(if
			(and
				(or
					(and
						(< (self distanceTo: gEgo) 80)
						(or (== gEgoEdgeHit 1) (== gEgoEdgeHit 3))
					)
					(and
						(< (self distanceTo: gEgo) 60)
						(or (== gEgoEdgeHit 2) (== gEgoEdgeHit 4))
					)
				)
				(not (and (< (gEgo view:) 238) (> (gEgo view:) 229)))
				(== (gEgo script:) 0)
				(not (& (gEgo signal:) $0080))
				(!= (gEgo view:) 792)
				(!= (gEgo view:) 132)
				(!= (gEgo view:) 218)
				(not local27)
			)
			(= local27 1)
			(switch gDisguiseNum
				(0 ; outlaw
					(sweepRgn setScript: yourDead)
				)
				(4 ; yeoman
					(sweepRgn setScript: bustedPuck)
				)
				(6 ; fens monk
					(sweepRgn setScript: bustedFensMonk)
				)
				(5 ; abbey monk
					(sweepRgn setScript: bustedAbbeyMonk)
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(sweepRgn setScript: surrenderToSweep)
			)
			(2 ; Look
				(Say 1750 59 0) ; "The Sheriff's men are nearly upon me!"
			)
			(3 ; Do
				(Say 1750 60 0) ; "I must escape or I'm a dead man!"
			)
			(10 ; Longbow
				(if (== gDisguiseNum 0) ; outlaw
					(= local31 1)
					(sweepRgn setScript: 0)
					(self setScript: yourDead)
				else
					(Say 1750 64 1) ; "That would get me killed on the spot. I'm hopelessly outnumbered."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance outlawSweep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo actions: handJive)
				(if (== gCurRoomNum 220) ; forest
					(if
						(or
							(== gForestRoomNum 7)
							(== gForestRoomNum 27)
							(== gForestRoomNum 60)
							(== gForestRoomNum 2)
							(== gForestRoomNum 17)
							(== gForestRoomNum 32)
							(== gForestRoomNum 76)
							(== gForestRoomNum 171)
							(== gForestRoomNum 183)
							(== gForestRoomNum 64)
							(== gForestRoomNum 129)
							(== gForestRoomNum 146)
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 86)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 102)
							(== gForestRoomNum 168)
						)
						(HandsOff)
					)
					(gEgo setMotion: PolyPath 160 150 self)
				else
					(= ticks 4)
				)
			)
			(1
				(if (== gCurRoomNum 180)
					(if (or (== gEgoEdgeHit 2) (== gEgoEdgeHit 1))
						(= local32 1)
					else
						(= local32 0)
					)
				)
				(++ gForestSweepRoomCount)
				(gSFX2 number: 402 loop: 1 play: self)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (not (IsFlag 115))
					(cond
						((== gDay 9)
							(Converse @local34 local4 0 self) ; "What the devil--? It sounds like a horde of men crashing through the Forest."
						)
						((== gDay 12)
							(Converse @local38 local4 0 self) ; "That thrashing in the forest--is it--"
						)
					)
				else
					(self cue:)
				)
			)
			(3
				(if (not (HaveMouse))
					(gGame
						setCursor: gTheCursor 1 (gEgo x:) (- (gEgo y:) 20)
					)
				)
				(if
					(and
						(== gCurRoomNum 220) ; forest
						(or
							(== gForestRoomNum 7)
							(== gForestRoomNum 27)
							(== gForestRoomNum 60)
							(== gForestRoomNum 2)
							(== gForestRoomNum 17)
							(== gForestRoomNum 32)
							(== gForestRoomNum 76)
							(== gForestRoomNum 171)
							(== gForestRoomNum 183)
							(== gForestRoomNum 64)
							(== gForestRoomNum 129)
							(== gForestRoomNum 146)
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 86)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 102)
							(== gForestRoomNum 168)
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 54)
							(== gForestRoomNum 70)
							(== gForestRoomNum 86)
							(== gForestRoomNum 101)
							(== gForestRoomNum 117)
							(== gForestRoomNum 133)
							(== gForestRoomNum 149)
							(== gForestRoomNum 9)
							(== gForestRoomNum 25)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 71)
							(== gForestRoomNum 87)
							(== gForestRoomNum 102)
							(== gForestRoomNum 118)
							(== gForestRoomNum 134)
							(== gForestRoomNum 150)
							(== gForestRoomNum 26)
							(== gForestRoomNum 168)
							(== gForestRoomNum 58)
							(== gForestRoomNum 90)
							(== gForestRoomNum 121)
							(== gForestRoomNum 89)
							(== gForestRoomNum 136)
							(== gForestRoomNum 41)
							(== gForestRoomNum 73)
							(== gForestRoomNum 104)
							(== gForestRoomNum 151)
							(== gForestRoomNum 43)
							(== gForestRoomNum 75)
							(== gForestRoomNum 106)
							(== gForestRoomNum 153)
							(== gForestRoomNum 166)
							(== gForestRoomNum 182)
						)
					)
					(sweepRgn setScript: cleanSweep)
				else
					(= seconds 5)
				)
			)
			(4
				(if (and (== gCurRoomNum 220) (< (gEgo y:) 100)) ; forest
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(5
				(gSFX number: 400 loop: -1 play:)
				(= local28 1)
				(if (== gDisguiseNum 0) ; outlaw
					((= local29 (sherMan new:))
						view: 753
						loop: 0
						x:
							(cond
								((== gCurRoomNum 220) ; forest
									(cond
										(
											(or
												(== gForestRoomNum 48)
												(== gForestRoomNum 81)
												(== gForestRoomNum 97)
												(== gForestRoomNum 113)
												(== gForestRoomNum 2)
												(== gForestRoomNum 17)
												(== gForestRoomNum 32)
												(== gForestRoomNum 64)
												(== gForestRoomNum 129)
												(== gForestRoomNum 146)
												(== gForestRoomNum 166)
												(== gForestRoomNum 182)
											)
											330
										)
										(
											(or
												(== gForestRoomNum 43)
												(== gForestRoomNum 91)
												(== gForestRoomNum 107)
												(== gForestRoomNum 123)
												(== gForestRoomNum 139)
												(== gForestRoomNum 76)
												(== gForestRoomNum 171)
												(== gForestRoomNum 183)
												(== gForestRoomNum 7)
												(== gForestRoomNum 27)
												(== gForestRoomNum 60)
												(== gForestRoomNum 156)
											)
											-10
										)
										(
											(or
												(== gForestRoomNum 3)
												(== gForestRoomNum 4)
												(== gForestRoomNum 5)
												(== gForestRoomNum 6)
												(== gForestRoomNum 24)
												(== gForestRoomNum 25)
												(== gForestRoomNum 26)
												(== gForestRoomNum 2)
												(== gForestRoomNum 17)
												(== gForestRoomNum 32)
												(== gForestRoomNum 7)
												(== gForestRoomNum 27)
												(== gForestRoomNum 60)
											)
											280
										)
										(
											(or
												(== gForestRoomNum 147)
												(== gForestRoomNum 148)
												(== gForestRoomNum 149)
												(== gForestRoomNum 168)
												(== gForestRoomNum 169)
												(== gForestRoomNum 170)
												(== gForestRoomNum 182)
												(== gForestRoomNum 64)
												(== gForestRoomNum 129)
												(== gForestRoomNum 146)
												(== gForestRoomNum 76)
												(== gForestRoomNum 171)
												(== gForestRoomNum 183)
											)
											320
										)
										(else 0)
									)
								)
								(local32 325)
								(else 0)
							)
						y:
							(if (== gCurRoomNum 220) ; forest
								(cond
									(
										(or
											(== gForestRoomNum 48)
											(== gForestRoomNum 81)
											(== gForestRoomNum 97)
											(== gForestRoomNum 113)
											(== gForestRoomNum 2)
											(== gForestRoomNum 17)
											(== gForestRoomNum 32)
											(== gForestRoomNum 64)
											(== gForestRoomNum 129)
											(== gForestRoomNum 146)
											(== gForestRoomNum 166)
											(== gForestRoomNum 182)
										)
										85
									)
									(
										(or
											(== gForestRoomNum 43)
											(== gForestRoomNum 91)
											(== gForestRoomNum 107)
											(== gForestRoomNum 123)
											(== gForestRoomNum 139)
											(== gForestRoomNum 76)
											(== gForestRoomNum 171)
											(== gForestRoomNum 183)
											(== gForestRoomNum 7)
											(== gForestRoomNum 27)
											(== gForestRoomNum 60)
											(== gForestRoomNum 156)
										)
										120
									)
									(
										(or
											(== gForestRoomNum 3)
											(== gForestRoomNum 4)
											(== gForestRoomNum 5)
											(== gForestRoomNum 6)
											(== gForestRoomNum 24)
											(== gForestRoomNum 25)
											(== gForestRoomNum 26)
											(== gForestRoomNum 2)
											(== gForestRoomNum 17)
											(== gForestRoomNum 32)
											(== gForestRoomNum 7)
											(== gForestRoomNum 27)
											(== gForestRoomNum 60)
										)
										240
									)
									(
										(or
											(== gForestRoomNum 147)
											(== gForestRoomNum 148)
											(== gForestRoomNum 149)
											(== gForestRoomNum 168)
											(== gForestRoomNum 169)
											(== gForestRoomNum 170)
											(== gForestRoomNum 182)
											(== gForestRoomNum 64)
											(== gForestRoomNum 129)
											(== gForestRoomNum 146)
											(== gForestRoomNum 76)
											(== gForestRoomNum 171)
											(== gForestRoomNum 183)
										)
										85
									)
									(else 92)
								)
							else
								179
							)
						init:
						setCycle: Walk
					)
					(cond
						((== gCurRoomNum 220) ; forest
							(cond
								(
									(or
										(== gForestRoomNum 48)
										(== gForestRoomNum 81)
										(== gForestRoomNum 97)
										(== gForestRoomNum 113)
										(== gForestRoomNum 2)
										(== gForestRoomNum 17)
										(== gForestRoomNum 32)
										(== gForestRoomNum 64)
										(== gForestRoomNum 129)
										(== gForestRoomNum 146)
										(== gForestRoomNum 166)
										(== gForestRoomNum 182)
									)
									(local29 setMotion: PolyPath 275 90 self)
								)
								(
									(or
										(== gForestRoomNum 43)
										(== gForestRoomNum 91)
										(== gForestRoomNum 107)
										(== gForestRoomNum 123)
										(== gForestRoomNum 139)
										(== gForestRoomNum 76)
										(== gForestRoomNum 171)
										(== gForestRoomNum 183)
										(== gForestRoomNum 7)
										(== gForestRoomNum 27)
										(== gForestRoomNum 60)
										(== gForestRoomNum 156)
									)
									(local29 setMotion: PolyPath 30 120 self)
								)
								(
									(or
										(== gForestRoomNum 3)
										(== gForestRoomNum 4)
										(== gForestRoomNum 5)
										(== gForestRoomNum 6)
										(== gForestRoomNum 24)
										(== gForestRoomNum 25)
										(== gForestRoomNum 26)
										(== gForestRoomNum 2)
										(== gForestRoomNum 17)
										(== gForestRoomNum 32)
										(== gForestRoomNum 7)
										(== gForestRoomNum 27)
										(== gForestRoomNum 60)
									)
									(local29 setMotion: PolyPath 280 185 self)
								)
								(
									(or
										(== gForestRoomNum 147)
										(== gForestRoomNum 148)
										(== gForestRoomNum 149)
										(== gForestRoomNum 168)
										(== gForestRoomNum 169)
										(== gForestRoomNum 170)
										(== gForestRoomNum 182)
										(== gForestRoomNum 64)
										(== gForestRoomNum 129)
										(== gForestRoomNum 146)
										(== gForestRoomNum 76)
										(== gForestRoomNum 171)
										(== gForestRoomNum 183)
									)
									(local29 setMotion: PolyPath 275 90 self)
								)
								(else
									(local29 setMotion: PolyPath 30 92 self)
								)
							)
						)
						(local32
							(local29 setMotion: PolyPath 290 179 self)
						)
						(else
							(local29 setMotion: PolyPath 30 179 self)
						)
					)
				else
					(self cue:)
				)
			)
			(6
				(if (== gDisguiseNum 0) ; outlaw
					(Face local29 gEgo)
					(= ticks 30)
				else
					(self cue:)
				)
			)
			(7
				(if (== gDisguiseNum 0) ; outlaw
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Say 1750 3 0 80 {Sheriff's Man}) ; "Over here! It's Robin Hood! ROBIN HOOD!"
				)
				(= seconds 4)
			)
			(8
				(if (== gDisguiseNum 0) ; outlaw
					(local29 setMotion: PChase gEgo 30)
				)
				(switch gForestSweepRoomCount
					(4
						(= seconds 5)
					)
					(5
						(= seconds 4)
					)
					(6
						(= seconds 3)
					)
					(7
						(= seconds 1)
					)
				)
			)
			(9
				(if (== gCurRoomNum 220) ; forest
					(proc750_1)
				)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance cleanSweep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo actions: handJive)
				(if
					(and
						(== gCurRoomNum 220) ; forest
						(or
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 54)
							(== gForestRoomNum 70)
							(== gForestRoomNum 86)
							(== gForestRoomNum 101)
							(== gForestRoomNum 117)
							(== gForestRoomNum 133)
							(== gForestRoomNum 149)
							(== gForestRoomNum 9)
							(== gForestRoomNum 25)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 71)
							(== gForestRoomNum 87)
							(== gForestRoomNum 102)
							(== gForestRoomNum 118)
							(== gForestRoomNum 134)
							(== gForestRoomNum 150)
							(== gForestRoomNum 26)
							(== gForestRoomNum 168)
							(== gForestRoomNum 58)
							(== gForestRoomNum 90)
							(== gForestRoomNum 121)
							(== gForestRoomNum 89)
							(== gForestRoomNum 136)
							(== gForestRoomNum 41)
							(== gForestRoomNum 73)
							(== gForestRoomNum 104)
							(== gForestRoomNum 151)
							(== gForestRoomNum 43)
							(== gForestRoomNum 75)
							(== gForestRoomNum 106)
							(== gForestRoomNum 153)
							(== gForestRoomNum 166)
							(== gForestRoomNum 182)
						)
					)
					(HandsOff)
				)
				(= ticks 12)
			)
			(1
				(if (== (++ gForestSweepRoomCount) 4)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Converse @local52 local4 0 self) ; "I hear the Sheriff's men getting closer!"
				else
					(self cue:)
				)
			)
			(2
				(if (not (HaveMouse))
					(gGame
						setCursor: gTheCursor 1 (gEgo x:) (- (gEgo y:) 20)
					)
				)
				(if
					(or
						(== gForestRoomNum 7)
						(== gForestRoomNum 27)
						(== gForestRoomNum 60)
						(== gForestRoomNum 2)
						(== gForestRoomNum 17)
						(== gForestRoomNum 32)
						(== gForestRoomNum 76)
						(== gForestRoomNum 171)
						(== gForestRoomNum 183)
						(== gForestRoomNum 64)
						(== gForestRoomNum 129)
						(== gForestRoomNum 146)
						(== gForestRoomNum 24)
						(== gForestRoomNum 39)
						(== gForestRoomNum 86)
						(== gForestRoomNum 40)
						(== gForestRoomNum 55)
						(== gForestRoomNum 102)
						(== gForestRoomNum 168)
						(== gForestRoomNum 24)
						(== gForestRoomNum 39)
						(== gForestRoomNum 54)
						(== gForestRoomNum 70)
						(== gForestRoomNum 86)
						(== gForestRoomNum 101)
						(== gForestRoomNum 117)
						(== gForestRoomNum 133)
						(== gForestRoomNum 149)
						(== gForestRoomNum 9)
						(== gForestRoomNum 25)
						(== gForestRoomNum 40)
						(== gForestRoomNum 55)
						(== gForestRoomNum 71)
						(== gForestRoomNum 87)
						(== gForestRoomNum 102)
						(== gForestRoomNum 118)
						(== gForestRoomNum 134)
						(== gForestRoomNum 150)
						(== gForestRoomNum 26)
						(== gForestRoomNum 168)
						(== gForestRoomNum 58)
						(== gForestRoomNum 90)
						(== gForestRoomNum 121)
						(== gForestRoomNum 89)
						(== gForestRoomNum 136)
						(== gForestRoomNum 41)
						(== gForestRoomNum 73)
						(== gForestRoomNum 104)
						(== gForestRoomNum 151)
						(== gForestRoomNum 43)
						(== gForestRoomNum 75)
						(== gForestRoomNum 106)
						(== gForestRoomNum 153)
						(== gForestRoomNum 166)
						(== gForestRoomNum 182)
					)
					(-- gForestSweepRoomCount)
					(= ticks 2)
				else
					(switch gForestSweepRoomCount
						(4
							(= ticks 400)
						)
						(5
							(= ticks 300)
						)
						(else
							(= ticks 180)
						)
					)
				)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Converse @local56 local4 0 self) ; "They're almost upon me!"
			)
			(4
				(if (not (HaveMouse))
					(gGame
						setCursor: gTheCursor 1 (gEgo x:) (- (gEgo y:) 20)
					)
				)
				(if
					(or
						(== gForestRoomNum 7)
						(== gForestRoomNum 27)
						(== gForestRoomNum 60)
						(== gForestRoomNum 2)
						(== gForestRoomNum 17)
						(== gForestRoomNum 32)
						(== gForestRoomNum 76)
						(== gForestRoomNum 171)
						(== gForestRoomNum 183)
						(== gForestRoomNum 64)
						(== gForestRoomNum 129)
						(== gForestRoomNum 146)
						(== gForestRoomNum 24)
						(== gForestRoomNum 39)
						(== gForestRoomNum 86)
						(== gForestRoomNum 40)
						(== gForestRoomNum 55)
						(== gForestRoomNum 102)
						(== gForestRoomNum 168)
						(== gForestRoomNum 24)
						(== gForestRoomNum 39)
						(== gForestRoomNum 54)
						(== gForestRoomNum 70)
						(== gForestRoomNum 86)
						(== gForestRoomNum 101)
						(== gForestRoomNum 117)
						(== gForestRoomNum 133)
						(== gForestRoomNum 149)
						(== gForestRoomNum 9)
						(== gForestRoomNum 25)
						(== gForestRoomNum 40)
						(== gForestRoomNum 55)
						(== gForestRoomNum 71)
						(== gForestRoomNum 87)
						(== gForestRoomNum 102)
						(== gForestRoomNum 118)
						(== gForestRoomNum 134)
						(== gForestRoomNum 150)
						(== gForestRoomNum 26)
						(== gForestRoomNum 168)
						(== gForestRoomNum 58)
						(== gForestRoomNum 90)
						(== gForestRoomNum 121)
						(== gForestRoomNum 89)
						(== gForestRoomNum 136)
						(== gForestRoomNum 41)
						(== gForestRoomNum 73)
						(== gForestRoomNum 104)
						(== gForestRoomNum 151)
						(== gForestRoomNum 43)
						(== gForestRoomNum 75)
						(== gForestRoomNum 106)
						(== gForestRoomNum 153)
						(== gForestRoomNum 166)
						(== gForestRoomNum 182)
					)
					(self cue:)
				else
					(switch gForestSweepRoomCount
						(4
							(= ticks 500)
						)
						(5
							(= ticks 450)
						)
						(else
							(= ticks 375)
						)
					)
				)
			)
			(5
				(if (== gDisguiseNum 0) ; outlaw
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Say 1750 4 self 80 {Sheriff's Man}) ; "This way, I've spotted him!"
				else
					(self cue:)
				)
			)
			(6
				(if
					(or
						(== gForestRoomNum 7)
						(== gForestRoomNum 27)
						(== gForestRoomNum 60)
						(== gForestRoomNum 2)
						(== gForestRoomNum 17)
						(== gForestRoomNum 32)
						(== gForestRoomNum 76)
						(== gForestRoomNum 171)
						(== gForestRoomNum 183)
						(== gForestRoomNum 64)
						(== gForestRoomNum 129)
						(== gForestRoomNum 146)
						(== gForestRoomNum 24)
						(== gForestRoomNum 39)
						(== gForestRoomNum 86)
						(== gForestRoomNum 40)
						(== gForestRoomNum 55)
						(== gForestRoomNum 102)
						(== gForestRoomNum 168)
						(== gForestRoomNum 24)
						(== gForestRoomNum 39)
						(== gForestRoomNum 54)
						(== gForestRoomNum 70)
						(== gForestRoomNum 86)
						(== gForestRoomNum 101)
						(== gForestRoomNum 117)
						(== gForestRoomNum 133)
						(== gForestRoomNum 149)
						(== gForestRoomNum 9)
						(== gForestRoomNum 25)
						(== gForestRoomNum 40)
						(== gForestRoomNum 55)
						(== gForestRoomNum 71)
						(== gForestRoomNum 87)
						(== gForestRoomNum 102)
						(== gForestRoomNum 118)
						(== gForestRoomNum 134)
						(== gForestRoomNum 150)
						(== gForestRoomNum 26)
						(== gForestRoomNum 168)
						(== gForestRoomNum 58)
						(== gForestRoomNum 90)
						(== gForestRoomNum 121)
						(== gForestRoomNum 89)
						(== gForestRoomNum 136)
						(== gForestRoomNum 41)
						(== gForestRoomNum 73)
						(== gForestRoomNum 104)
						(== gForestRoomNum 151)
						(== gForestRoomNum 43)
						(== gForestRoomNum 75)
						(== gForestRoomNum 106)
						(== gForestRoomNum 153)
						(== gForestRoomNum 166)
						(== gForestRoomNum 182)
					)
					(self cue:)
				else
					(switch gForestSweepRoomCount
						(4
							(= seconds 5)
						)
						(5
							(= seconds 3)
						)
						(6
							(= seconds 2)
						)
						(else
							(self cue:)
						)
					)
				)
			)
			(7
				(gSFX number: 400 loop: -1 play:)
				(cond
					(
						(or
							(== gForestRoomNum 7)
							(== gForestRoomNum 27)
							(== gForestRoomNum 60)
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 86)
						)
						(gEgo setMotion: PolyPath 0 97 self)
					)
					((or (== gForestRoomNum 2) (== gForestRoomNum 17) (== gForestRoomNum 32))
						(gEgo setMotion: PolyPath 319 103 self)
					)
					(
						(or
							(== gForestRoomNum 76)
							(== gForestRoomNum 171)
							(== gForestRoomNum 183)
						)
						(gEgo setMotion: PolyPath 0 147 self)
					)
					(
						(or
							(== gForestRoomNum 64)
							(== gForestRoomNum 129)
							(== gForestRoomNum 146)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 102)
							(== gForestRoomNum 58)
						)
						(gEgo setMotion: PolyPath 319 145 self)
					)
					(else
						(HandsOn)
						(self cue:)
					)
				)
			)
			(8
				(= local28 1)
				(= ticks 2)
			)
			(9
				(if (< (gEgo y:) 100)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(10
				(gSFX number: 400 loop: -1 play:)
				(proc750_1)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance nearGrove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
			)
			(1
				(Say ; "You must reach the heart of the grove for our magic to work, fleshling."
					1750
					62
					self
					80
					(switch global124
						(11 {Birch})
						(12 {Rowan})
						(13 {Ash})
						(14 {Alder})
						(15 {Holly})
						(16 {Hazel})
						(17 {Elder})
						(18 {Oak})
					)
				)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance myArrow of PicView
	(properties
		view 792
		loop 4
		cel 2
		signal 16384
	)

	(method (init)
		(self x: (+ (gEgo x:) 37) y: (+ (gEgo y:) 6))
		(super init:)
	)
)

(instance yourDead of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local31
					(Face gEgo (self client:))
				)
				(= ticks 18)
			)
			(1
				(if local31
					(gEgo view: 4 setCel: 0 setCycle: End self)
				else
					(self cue:)
				)
			)
			(2
				(if (== gCurRoomNum 180)
					((ScriptID 180 1) hide:) ; oakMan
				)
				(if
					(and
						(== gCurRoomNum 220) ; forest
						(OneOf
							gForestRoomNum
							2
							3
							4
							5
							6
							7
							17
							24
							25
							26
							27
							32
							43
							48
							60
							64
							76
							81
							91
							97
							107
							113
							123
							129
							139
							146
							147
							148
							149
							156
							168
							169
							170
							171
							183
						)
					)
					((ScriptID 225 4) hide:) ; liveBush
				)
				(= local31 0)
				(= local33 (gCurRoom picture:))
				(if (gCast contains: local29)
					(local29 setMotion: 0 setCycle: 0 hide:)
				)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (gCast contains: [local17 temp0])
						([local17 temp0] setMotion: 0 setCycle: 0 hide:)
					)
				)
				(gEgo hide:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCurRoom drawPic: 803 8)
				(= ticks 20)
			)
			(3
				(gRgnMusic2 number: 906 loop: 1 play: self)
			)
			(4
				(gRgnMusic2 number: 907 loop: 1 play: self)
			)
			(5
				(gSFX number: 25 loop: -1 play:)
				(gCurRoom drawPic: local33 8)
				(if (== gCurRoomNum 220) ; forest
					(cond
						(
							(or
								(== gForestRoomNum 132)
								(== gForestRoomNum 155)
								(== gForestRoomNum 34)
								(== gForestRoomNum 53)
								(== gForestRoomNum 120)
								(== gForestRoomNum 66)
								(== gForestRoomNum 20)
								(== gForestRoomNum 114)
								(== gForestRoomNum 22)
								(== gForestRoomNum 122)
								(== gForestRoomNum 88)
								(== gForestRoomNum 49)
							)
							(proc225_0)
						)
						(
							(or
								(== gForestRoomNum 18)
								(== gForestRoomNum 33)
								(== gForestRoomNum 35)
								(== gForestRoomNum 52)
								(== gForestRoomNum 54)
								(== gForestRoomNum 69)
								(== gForestRoomNum 119)
								(== gForestRoomNum 121)
								(== gForestRoomNum 135)
								(== gForestRoomNum 137)
								(== gForestRoomNum 51)
								(== gForestRoomNum 65)
								(== gForestRoomNum 82)
								(== gForestRoomNum 19)
								(== gForestRoomNum 21)
								(== gForestRoomNum 36)
								(== gForestRoomNum 98)
								(== gForestRoomNum 115)
								(== gForestRoomNum 130)
								(== gForestRoomNum 23)
								(== gForestRoomNum 37)
								(== gForestRoomNum 38)
								(== gForestRoomNum 106)
								(== gForestRoomNum 138)
								(== gForestRoomNum 50)
								(== gForestRoomNum 67)
								(== gForestRoomNum 68)
								(== gForestRoomNum 72)
								(== gForestRoomNum 83)
								(== gForestRoomNum 85)
								(== gForestRoomNum 86)
								(== gForestRoomNum 89)
								(== gForestRoomNum 99)
								(== gForestRoomNum 100)
								(== gForestRoomNum 101)
								(== gForestRoomNum 104)
								(== gForestRoomNum 136)
								(== gForestRoomNum 151)
								(== gForestRoomNum 153)
								(== gForestRoomNum 167)
							)
							(proc225_1)
						)
						(
							(OneOf
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								183
							)
							(proc225_2)
							((ScriptID 225 4) show:) ; liveBush
						)
					)
				)
				(if (== gCurRoomNum 180)
					((ScriptID 180 1) show:) ; oakMan
				)
				(switch gDisguiseNum
					(0 ; outlaw
						(if (== gCurRoomNum 220) ; forest
							(gEgo posn: 103 137)
						else
							(gEgo posn: 92 157)
						)
						(gEgo view: 792 setLoop: 1 setCel: 6 show:)
						(AddToAddToPics myArrow)
					)
					(4 ; yeoman
						(if (== gCurRoomNum 220) ; forest
							(gEgo posn: 93 144)
						else
							(gEgo posn: 96 167)
						)
						(gEgo view: 132 setLoop: 5 setCel: 5 show:)
					)
					(6 ; fens monk
						(if (== gCurRoomNum 220) ; forest
							(gEgo posn: 115 151)
						else
							(gEgo posn: 110 170)
						)
						(gEgo view: 218 setLoop: 3 setCel: 6 show:)
					)
				)
				(cond
					((gCast contains: local29)
						(local29
							view: 754
							loop: 2
							cel: 0
							x: 102
							y: (if (== gCurRoomNum 220) 129 else 156) ; forest
							init:
						)
					)
					((gCast contains: [local17 0])
						([local17 0]
							view: 754
							loop: 2
							cel: 0
							x: 102
							y: (if (== gCurRoomNum 220) 129 else 156) ; forest
							init:
						)
					)
					(else
						((= [local17 0] (sherMan new:))
							view: 754
							loop: 2
							cel: 0
							x: 102
							y: (if (== gCurRoomNum 220) 129 else 156) ; forest
							init:
						)
					)
				)
				(if (gCast contains: [local17 1])
					([local17 1]
						view: 754
						loop: 0
						cel: 0
						x: (if (== gCurRoomNum 220) 90 else 79) ; forest
						y: (if (== gCurRoomNum 220) 160 else 172) ; forest
						init:
					)
				else
					((= [local17 1] (sherMan new:))
						view: 754
						loop: 0
						cel: 0
						x: (if (== gCurRoomNum 220) 90 else 79) ; forest
						y: (if (== gCurRoomNum 220) 160 else 172) ; forest
						init:
					)
				)
				(if (gCast contains: [local17 2])
					([local17 2]
						view: 754
						loop: 1
						cel: 0
						x: 171
						y: (if (== gCurRoomNum 220) 148 else 174) ; forest
						init:
					)
				else
					((= [local17 2] (sherMan new:))
						view: 754
						loop: 1
						cel: 0
						x: 171
						y: (if (== gCurRoomNum 220) 148 else 174) ; forest
						init:
					)
				)
				(= ticks 60)
			)
			(6
				(HandsOn)
				(gTheIconBar disable: 5)
				(if (or (== client bustedPuck) (== client bustedFensMonk))
					(self dispose:)
				else
					(sweepRgn setScript: sweptToDeath)
				)
			)
		)
	)
)

(instance surroundEgo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gSFX number: 401 loop: -1 play:)
				(cond
					(
						(OneOf
							gForestRoomNum
							2
							3
							4
							5
							6
							7
							17
							24
							25
							26
							27
							32
							43
							48
							60
							64
							76
							81
							91
							97
							107
							113
							123
							129
							139
							146
							147
							148
							149
							156
							168
							169
							170
							171
							183
						)
						(cond
							(
								(or
									(== gForestRoomNum 3)
									(== gForestRoomNum 4)
									(== gForestRoomNum 5)
									(== gForestRoomNum 6)
									(== gForestRoomNum 24)
									(== gForestRoomNum 25)
									(== gForestRoomNum 26)
								)
								(= local264 0)
							)
							(
								(or
									(== gForestRoomNum 147)
									(== gForestRoomNum 148)
									(== gForestRoomNum 149)
									(== gForestRoomNum 168)
									(== gForestRoomNum 169)
									(== gForestRoomNum 170)
									(== gForestRoomNum 182)
								)
								(= local264 4)
							)
							(
								(or
									(== gForestRoomNum 43)
									(== gForestRoomNum 91)
									(== gForestRoomNum 107)
									(== gForestRoomNum 123)
									(== gForestRoomNum 139)
								)
								(= local264 8)
							)
							(
								(or
									(== gForestRoomNum 48)
									(== gForestRoomNum 81)
									(== gForestRoomNum 97)
									(== gForestRoomNum 113)
								)
								(= local264 12)
							)
						)
					)
					((== gCurRoomNum 220) ; forest
						(= local264 16)
					)
					(else
						(= local264 20)
					)
				)
				(= ticks 20)
			)
			(1
				(if (== gCurRoomNum 220) ; forest
					(gEgo setMotion: PolyPath 185 114 self)
				else
					(gEgo setMotion: PolyPath 110 180 self)
				)
			)
			(2
				(= local265 local264)
				(= local266 (+ local264 1))
				(= local267 (+ local264 2))
				(= local268 (+ local264 3))
				(gEgo setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 1))
				(cond
					((gCast contains: local29)
						(local29
							setMotion:
								PolyPath
								[local140 local267]
								[local140 local268]
						)
					)
					((gCast contains: [local17 0])
						([local17 0]
							setMotion:
								PolyPath
								[local140 local267]
								[local140 local268]
						)
					)
					(else
						((= [local17 0] (sherMan new:))
							view: 753
							loop: 0
							x: [local140 local265]
							y: [local140 local266]
							init:
							setCycle: Walk
							setMotion:
								PolyPath
								[local140 local267]
								[local140 local268]
						)
					)
				)
				(if (gCast contains: [local17 1])
					([local17 1]
						setMotion:
							PolyPath
							[local180 local267]
							[local180 local268]
					)
				else
					((= [local17 1] (sherMan new:))
						view: 753
						loop: 0
						x: [local180 local265]
						y: [local180 local266]
						init:
						setCycle: Walk
						setMotion:
							PolyPath
							[local180 local267]
							[local180 local268]
					)
				)
				(if (gCast contains: [local17 2])
					([local17 2]
						setMotion:
							PolyPath
							[local220 local267]
							[local220 local268]
							self
					)
				else
					((= [local17 2] (sherMan new:))
						view: 753
						loop: 1
						x: [local220 local265]
						y: [local220 local266]
						init:
						setCycle: Walk
						setMotion:
							PolyPath
							[local220 local267]
							[local220 local268]
							self
					)
				)
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 5)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (gCast contains: [local17 temp0])
						(Face [local17 temp0] gEgo)
					)
				)
				(switch gDisguiseNum
					(5 ; abbey monk
						(sweepRgn setScript: bustedAbbeyMonk)
					)
					(6 ; fens monk
						(sweepRgn setScript: bustedFensMonk)
					)
					(4 ; yeoman
						(sweepRgn setScript: bustedPuck)
					)
					(else
						(sweepRgn setScript: yourDead)
					)
				)
			)
		)
	)
)

(instance surrenderToSweep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gDisguiseNum 0) ; outlaw
					(Converse 2 @local43 local4 0 19 1 self) ; "Hold fast, I surrender!"
				else
					(Converse 1 @local48 local4 0 self) ; "Hold fast, I surrender!"
				)
			)
			(1
				(if (== gDisguiseNum 5) ; abbey monk
					(sweepRgn setScript: bustedAbbeyMonk)
				else
					(sweepRgn setScript: yourDead)
				)
				(HandsOn)
			)
		)
	)
)

(instance sweptToDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 18)
			)
			(1
				(Converse 3 @local110 19 0 @local131 1 20 2 self) ; "We got'em! We killed the most famous outlaw of'em all!"
			)
			(2
				(HandsOn)
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance bustedFensMonk of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: local29)
					(local29 setMotion: 0 setCycle: 0)
				)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (gCast contains: [local17 temp0])
						([local17 temp0] setMotion: 0 setCycle: 0)
					)
				)
				(= ticks 30)
			)
			(1
				(Converse 3 @local103 8 0 19 1 @local131 2 self) ; "Pardon me, did ye see an outlaw run this way?"
			)
			(2
				(self setScript: yourDead self)
			)
			(3
				(Converse 3 @local125 19 0 @local131 1 20 2 self) ; "Serves 'im right, tryin' to hide as a man of the cloth."
			)
			(4
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance bustedAbbeyMonk of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: local29)
					(local29 setMotion: 0 setCycle: 0)
				)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (gCast contains: [local17 temp0])
						([local17 temp0] setMotion: 0 setCycle: 0)
					)
				)
				(= ticks 30)
			)
			(1
				(gSFX fade: 0 15 15 1)
				(Converse 2 @local76 9 0 19 1 self) ; "Brother, you are far from the abbey."
			)
			(2
				(HandsOn)
				(= gDeathNum 33)
				(SetFlag 194)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance bustedPuck of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gCast contains: local29)
					(local29 setMotion: 0 setCycle: 0)
				)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (gCast contains: [local17 temp0])
						([local17 temp0] setMotion: 0 setCycle: 0)
					)
				)
				(= ticks 30)
			)
			(1
				(Converse 4 @local86 6 0 19 1 @local131 2 20 3 self) ; "Hold fast, Yeoman. What's your business here?"
			)
			(2
				(self setScript: yourDead self)
			)
			(3
				(Converse 3 @local95 19 0 @local131 1 20 2 self) ; "You 'ave to get up pretty early to fool me."
			)
			(4
				(EgoDead)
				(self dispose:)
			)
		)
	)
)

(instance blowSweep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global111 (gEgo loop:))
				(if
					(or
						(== (gEgo loop:) 2)
						(== (gEgo loop:) 4)
						(== (gEgo loop:) 0)
						(== (gEgo loop:) 6)
					)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(gEgo view: 10 setCel: 0 setCycle: End self)
			)
			(1
				(gSFX2 number: 904 loop: 1 play:)
				(= seconds 4)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo global111 0 1)
				(sweepRgn setScript: surroundEgo)
				(self dispose:)
			)
		)
	)
)

(instance handSignCode of Code
	(properties)

	(method (doit)
		(cond
			((!= gDisguiseNum 0) ; outlaw
				(if
					(OneOf
						gForestRoomNum
						2
						3
						4
						5
						6
						7
						17
						24
						25
						26
						27
						32
						43
						48
						60
						64
						76
						81
						91
						97
						107
						113
						123
						129
						139
						146
						147
						148
						149
						156
						168
						169
						170
						171
						183
					)
					(Say 1750 66 1) ; "It would seem the bushes will not answer me in this guise."
				else
					(Say 1750 65 1) ; "It would seem the Trees will not answer me in this guise."
				)
				(proc750_2)
			)
			((IsFlag 35)
				(cond
					(
						(or
							(and
								(or (== gForestRoomNum 132) (== gForestRoomNum 155))
								(== global124 0)
							)
							(and (== gForestRoomNum 34) (== global124 1))
							(and
								(or (== gForestRoomNum 53) (== gForestRoomNum 120))
								(== global124 2)
							)
							(and (== gForestRoomNum 66) (== global124 3))
							(and (== gForestRoomNum 20) (== global124 4))
							(and (== gForestRoomNum 114) (== global124 5))
							(and
								(or (== gForestRoomNum 22) (== gForestRoomNum 122))
								(== global124 6)
							)
							(and
								(or (== gForestRoomNum 88) (== gForestRoomNum 49))
								(== global124 7)
							)
							(and
								(OneOf
									gForestRoomNum
									2
									3
									4
									5
									6
									7
									17
									24
									25
									26
									27
									32
									43
									48
									60
									64
									76
									81
									91
									97
									107
									113
									123
									129
									139
									146
									147
									148
									149
									156
									168
									169
									170
									171
									183
								)
								(== global124 9)
							)
							(and (== gCurRoomNum 180) (== global124 7))
						)
						(gSFX fade: 127 30 8 0)
						(gEgo setScript: (ScriptID 223 0)) ; englishTreeName
					)
					(
						(and
							(> gForestSweepRoomCount 3)
							(OneOf
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								183
							)
							(== global124 20)
						)
						(gEgo setScript: (ScriptID 225 3)) ; moveBushes
					)
					(
						(and
							(> gForestSweepRoomCount 3)
							(or
								(and
									(or (== gForestRoomNum 132) (== gForestRoomNum 155))
									(== global124 11)
								)
								(and (== gForestRoomNum 34) (== global124 12))
								(and
									(or (== gForestRoomNum 53) (== gForestRoomNum 120))
									(== global124 13)
								)
								(and (== gForestRoomNum 66) (== global124 14))
								(and (== gForestRoomNum 20) (== global124 15))
								(and (== gForestRoomNum 114) (== global124 16))
								(and
									(or (== gForestRoomNum 22) (== gForestRoomNum 122))
									(== global124 17)
								)
								(and
									(or (== gForestRoomNum 88) (== gForestRoomNum 49))
									(== global124 18)
								)
								(and
									(OneOf
										gForestRoomNum
										2
										3
										4
										5
										6
										7
										17
										24
										25
										26
										27
										32
										43
										48
										60
										64
										76
										81
										91
										97
										107
										113
										123
										129
										139
										146
										147
										148
										149
										156
										168
										169
										170
										171
										183
									)
									(== global124 20)
								)
								(and (== gCurRoomNum 180) (== global124 18))
							)
						)
						(gEgo setScript: (ScriptID 223 3)) ; turnToTree
					)
					(
						(or
							(and
								(OneOf
									gForestRoomNum
									2
									3
									4
									5
									6
									7
									17
									24
									25
									26
									27
									32
									43
									48
									60
									64
									76
									81
									91
									97
									107
									113
									123
									129
									139
									146
									147
									148
									149
									156
									168
									169
									170
									171
									183
								)
								(== global124 20)
							)
							(and
								(or (== gForestRoomNum 132) (== gForestRoomNum 155))
								(== global124 11)
							)
							(and (== gForestRoomNum 34) (== global124 12))
							(and
								(or (== gForestRoomNum 53) (== gForestRoomNum 120))
								(== global124 13)
							)
							(and (== gForestRoomNum 66) (== global124 14))
							(and (== gForestRoomNum 20) (== global124 15))
							(and (== gForestRoomNum 114) (== global124 16))
							(and
								(or (== gForestRoomNum 22) (== gForestRoomNum 122))
								(== global124 17)
							)
							(and
								(or (== gForestRoomNum 88) (== gForestRoomNum 49))
								(== global124 18)
							)
							(and
								(OneOf
									gForestRoomNum
									2
									3
									4
									5
									6
									7
									17
									24
									25
									26
									27
									32
									43
									48
									60
									64
									76
									81
									91
									97
									107
									113
									123
									129
									139
									146
									147
									148
									149
									156
									168
									169
									170
									171
									183
								)
								(== global124 20)
							)
							(and (== gCurRoomNum 180) (== global124 18))
						)
						(gEgo setScript: (ScriptID 223 1)) ; notSweeping
					)
					(else
						(-- gForestSweepRoomCount)
						(proc750_2)
					)
				)
			)
			((IsFlag 34)
				(cond
					(
						(or
							(and
								(or (== gForestRoomNum 132) (== gForestRoomNum 155))
								(== global124 0)
							)
							(and (== gForestRoomNum 34) (== global124 1))
							(and
								(or (== gForestRoomNum 53) (== gForestRoomNum 120))
								(== global124 2)
							)
							(and (== gForestRoomNum 66) (== global124 3))
							(and (== gForestRoomNum 20) (== global124 4))
							(and (== gForestRoomNum 114) (== global124 5))
							(and
								(or (== gForestRoomNum 22) (== gForestRoomNum 122))
								(== global124 6)
							)
							(and
								(or (== gForestRoomNum 88) (== gForestRoomNum 49))
								(== global124 7)
							)
							(and
								(OneOf
									gForestRoomNum
									2
									3
									4
									5
									6
									7
									17
									24
									25
									26
									27
									32
									43
									48
									60
									64
									76
									81
									91
									97
									107
									113
									123
									129
									139
									146
									147
									148
									149
									156
									168
									169
									170
									171
									183
								)
								(== global124 9)
							)
							(and (== gCurRoomNum 180) (== global124 7))
						)
						(gSFX fade: 127 30 8 0)
						(gEgo setScript: (ScriptID 223 0)) ; englishTreeName
					)
					(
						(or
							(and
								(or (== gForestRoomNum 132) (== gForestRoomNum 155))
								(== global124 11)
							)
							(and (== gForestRoomNum 34) (== global124 12))
							(and
								(or (== gForestRoomNum 53) (== gForestRoomNum 120))
								(== global124 13)
							)
							(and (== gForestRoomNum 66) (== global124 14))
							(and (== gForestRoomNum 20) (== global124 15))
							(and (== gForestRoomNum 114) (== global124 16))
							(and
								(or (== gForestRoomNum 22) (== gForestRoomNum 122))
								(== global124 17)
							)
							(and
								(or (== gForestRoomNum 88) (== gForestRoomNum 49))
								(== global124 18)
							)
							(and
								(OneOf
									gForestRoomNum
									2
									3
									4
									5
									6
									7
									17
									24
									25
									26
									27
									32
									43
									48
									60
									64
									76
									81
									91
									97
									107
									113
									123
									129
									139
									146
									147
									148
									149
									156
									168
									169
									170
									171
									183
								)
								(== global124 20)
							)
							(and (== gCurRoomNum 180) (== global124 18))
						)
						(gSFX fade: 127 30 8 0)
						(gEgo setScript: (ScriptID 223 2)) ; notBlessed
					)
					(else
						(-- gForestSweepRoomCount)
						(proc750_2)
					)
				)
			)
		)
	)
)

(instance handJive of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(switch theVerb
				(3 ; Do
					(cond
						(
							(and
								(== gCurRoomNum 220) ; forest
								(or
									(== gForestRoomNum 18)
									(== gForestRoomNum 33)
									(== gForestRoomNum 35)
									(== gForestRoomNum 52)
									(== gForestRoomNum 54)
									(== gForestRoomNum 69)
									(== gForestRoomNum 119)
									(== gForestRoomNum 121)
									(== gForestRoomNum 135)
									(== gForestRoomNum 137)
									(== gForestRoomNum 51)
									(== gForestRoomNum 65)
									(== gForestRoomNum 82)
									(== gForestRoomNum 19)
									(== gForestRoomNum 21)
									(== gForestRoomNum 36)
									(== gForestRoomNum 98)
									(== gForestRoomNum 115)
									(== gForestRoomNum 130)
									(== gForestRoomNum 23)
									(== gForestRoomNum 37)
									(== gForestRoomNum 38)
									(== gForestRoomNum 106)
									(== gForestRoomNum 138)
									(== gForestRoomNum 50)
									(== gForestRoomNum 67)
									(== gForestRoomNum 68)
									(== gForestRoomNum 72)
									(== gForestRoomNum 83)
									(== gForestRoomNum 85)
									(== gForestRoomNum 86)
									(== gForestRoomNum 89)
									(== gForestRoomNum 99)
									(== gForestRoomNum 100)
									(== gForestRoomNum 101)
									(== gForestRoomNum 104)
									(== gForestRoomNum 136)
									(== gForestRoomNum 151)
									(== gForestRoomNum 153)
									(== gForestRoomNum 167)
								)
							)
							(gEgo setScript: nearGrove)
							1
						)
						((and (== local28 1) (== gDisguiseNum 0)) ; outlaw
							(Say 1750 60 1) ; "I must escape or I'm a dead man!"
							1
						)
						(else
							(sweepRgn setScript: 0)
							(gSFX fade: 0 30 8 0)
							0
						)
					)
				)
				(4 ; Inventory
					(switch invItem
						(12 ; puzzleBox
							(Say 1750 61 0) ; "I've no time for that now!"
							1
						)
						(1 ; horn
							(if (> gForestSweepRoomCount 2)
								(gEgo setScript: blowSweep)
								1
							)
						)
					)
				)
			)
		)
	)
)

