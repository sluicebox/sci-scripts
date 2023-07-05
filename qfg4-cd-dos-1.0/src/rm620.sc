;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use GloryRm)
(use Scaler)

(public
	rm620 0
)

(instance rm620 of GloryRm
	(properties
		picture 620
		style 1024
		north 650
	)

	(method (init)
		(switch gPrevRoomNum
			(650
				(gLongSong doSongs: 630 631 632)
				(gEgo posn: 228 31)
			)
			(640
				(gEgo posn: 54 157)
			)
			(else
				(gEgo posn: 57 154)
			)
		)
		(gEgo init: setScaler: Scaler 105 32 180 31 normalize:)
		((ScriptID 633 0) init:) ; rm620Code
		(super init: 1)
	)

	(method (dispose)
		(if script
			(script dispose:)
		)
		((ScriptID 633 3) stop: clean: (ScriptID 633 3)) ; wasMusic3, wasMusic3
		(DisposeScript 633)
		(super dispose:)
	)
)

