;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n013)
(use GKEgo)
(use Array)
(use Cursor)
(use Game)
(use User)
(use System)

(public
	restartGame 0
)

(local
	local0
	local1
	local2
)

(instance restartGame of Room
	(properties
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(if (gGame keepBar:)
			(gGame keepBar: 0 keepIconBar:)
		)
		(for ((= local0 0)) (< local0 (gSounds size:)) ((++ local0))
			((gSounds at: local0) client: 0)
		)
		(gSounds eachElementDo: #stop)
		(super init:)
		(gTheIconBar disable:)
		(= local1 gTheCursor)
		(gGame setCursor: gWaitCursor 1)
		(gCurRoom setScript: doTheRestart)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance doTheRestart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (PalVary 2) ; PalVaryInfo
					(PalVary 3) ; PalVaryKill
				)
				(if (gKeyDownHandler size:)
					(gKeyDownHandler release:)
				)
				(if (gMouseDownHandler size:)
					(gMouseDownHandler release:)
				)
				(if (gWalkHandler size:)
					(gWalkHandler release:)
				)
				(if (and gCuees (gCuees size:))
					(gCuees dispose:)
					(= gCuees 0)
				)
				(if (IsFlag 470)
					(= local2 1)
				)
				(for ((= local0 0)) (<= local0 80) ((++ local0))
					((gInventory at: local0) owner: 0 state: 0)
				)
				(if (gTheIconBar curInvIcon:)
					(gTheIconBar
						curInvIcon: 0
						disableIcon:
							((gTheIconBar useIconItem:)
								setCursor: gNormalCursor
								yourself:
							)
					)
					(FrameOut)
				)
				(for ((= local0 100)) (< local0 240) ((++ local0))
					(if
						(OneOf
							local0
							207
							208
							211
							102
							103
							106
							176
							164
							165
							166
						)
						0
					else
						(= [gEgo local0] 0)
					)
				)
				((ScriptID 11 0) doit:) ; colorInit
				(if local2
					(SetFlag 470)
				)
				(SetFlag 52)
				(= global101 1234)
				(= global111 0)
				(= global115 6)
				(= global177 2)
				(= gGStopGroop (ScriptID 18 1)) ; gStopGroop
				(= gNarrator (ScriptID 22 0)) ; GKNarrator
				(= gUserFont 4)
				(= gDay 1)
				(User alterEgo: GKEgo canControl: 0 canInput: 0)
				(= gScore 0)
				(= global179 70)
				(for ((= local0 0)) (< local0 15) ((++ local0))
					(if (global176 at: local0)
						((global176 at: local0) dispose:)
						(global176 at: local0 0)
					)
				)
				(= global176 (IntArray new: 15))
				(= cycles 1)
			)
			(1
				(= gScore 0)
				(= cycles 1)
			)
			(2
				(gCurRoom newRoom: 375) ; titleRoom
			)
		)
	)
)

(instance myInvisCursor of Cursor ; UNUSED
	(properties
		view 996
	)
)

