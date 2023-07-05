;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64900)
(include sci.sh)
(use System)

(class FeatureInfo of Obj
	(properties
		hotspotVerbList 0
		forceCursor 0
		oApproachVerbs 0
		oExceptionVerbs 0
		bImAHog 0
	)

	(method (dispose)
		(if hotspotVerbList
			(hotspotVerbList release: dispose:)
		)
		(if oApproachVerbs
			(oApproachVerbs release: dispose:)
		)
		(if oExceptionVerbs
			(oExceptionVerbs release: dispose:)
		)
		(super dispose:)
	)
)

