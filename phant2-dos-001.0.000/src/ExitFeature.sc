;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63014)
(include sci.sh)
(use Main)
(use P2Feature)

(class ExitFeature of P2Feature
	(properties
		priority 205
		exitScene 0
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(super handleEvent: event)
				(& (event type:) evMOUSEBUTTON)
			)
			(= global209 exitScene)
			(= global211 sceneScored)
			(event claimed: 1)
			(return)
		)
	)
)

