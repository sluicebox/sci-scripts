;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 403)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use soFlashCyberSniff)
(use System)

(public
	ro403 0
)

(instance ro403 of L7Room
	(properties)

	(method (init)
		(super init: &rest)
		(gOMusic1 setMusic: 0)
		(gGame handsOff:)
		(self setScript: soCartoon)
	)
)

(instance soCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gMessager say: 0 0 1 1 self) ; "(WHISPER) Jamie? Jamie Lee?"
			)
			(2
				(PlayVMD 0 {11.vmd}) ; Open
				(if (< global294 1600)
					(PlayVMD 1 0 0 21 18 0 10000) ; Put
				else
					(PlayVMD 1 0 0 1) ; Put
				)
				(PlayVMD 14 1) ; WaitEvent
				(PlayVMD 6) ; Close
				(= cycles 3)
			)
			(3
				((ScriptID 64017 0) set: 104) ; oFlags
				((ScriptID 64017 0) set: 263) ; oFlags
				(CopyWinningWallpaper 1)
				(gCurRoom newRoom: 551) ; ro551
				(self dispose:)
			)
		)
	)
)

