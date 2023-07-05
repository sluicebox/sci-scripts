;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2700)
(include sci.sh)
(use Main)

(public
	rm2v70 0
)

(local
	local0
	local1
	local2
)

(instance rm2v70 of ShiversRoom
	(properties
		picture 2025
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(= local1 1)
		(= local2 0)
		(= local0 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2700
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& evMOUSEBUTTON (event type:)))
			(= local1 (not local1))
			(if (and (not local2) (< local0 1) (not local1))
				(gCurRoom drawPic: 2045)
				(= local2 1)
			else
				(gCurRoom drawPic: 2025)
				(= local2 0)
			)
		)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2700
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& evMOUSEBUTTON (event type:)))
			(= local1 (not local1))
			(if (and (not local2) (< local0 1) (not local1))
				(gCurRoom drawPic: 2045)
				(= local2 1)
			else
				(gCurRoom drawPic: 2025)
				(= local2 0)
			)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2700
	)

	(method (init)
		(self createPoly: 89 105 111 72 111 47 153 47 153 72 198 136 71 136)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (& evMOUSEBUTTON (event type:)))
			(if local2
				(gCurRoom newRoom: 2000) ; rm2v0
			else
				(if local1
					(++ local0)
				else
					(-- local0)
				)
				(if (< local0 1)
					(gCurRoom drawPic: 2045)
					(= local2 1)
				)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

