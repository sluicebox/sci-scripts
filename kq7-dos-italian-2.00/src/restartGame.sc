;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use aEgoTalker)
(use skipCartoon)
(use Grooper)
(use User)
(use System)

(public
	restartGame 0
)

(local
	local0
)

(instance restartGame of KQRoom
	(properties)

	(method (init)
		(for ((= local0 0)) (< local0 (gSounds size:)) ((++ local0))
			((gSounds at: local0) client: 0)
		)
		(gSounds eachElementDo: #stop)
		(super init:)
		(self setScript: doTheRestart)
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
				(for ((= local0 0)) (< local0 80) ((++ local0))
					((gInventory at: local0) owner: 0 state: 0)
				)
				(for ((= local0 100)) (< local0 240) ((++ local0))
					(if (OneOf local0 102 103 106 107)
						0
					else
						(= [gEgo local0] 0)
					)
				)
				((ScriptID 0 5) client: 0 delete: dispose:) ; lavaDeathTimer
				((ScriptID 0 6) client: 0 delete: dispose:) ; scorpDeathTimer
				((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
				((ScriptID 0 8) client: 0 delete: dispose:) ; stormDeathTimer
				(= gValOrRoz -4) ; Val
				(= gChapter 1)
				(= global302 1)
				(= global303 2)
				(= global304 3)
				(= global101 1234)
				(= global115 6)
				(= gGrooper Grooper)
				(= gUserFont 4)
				(User alterEgo: KQEgo canControl: 0 canInput: 0)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 26)
			)
		)
	)
)

