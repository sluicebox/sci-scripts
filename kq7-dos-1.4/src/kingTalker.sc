;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7001)
(include sci.sh)
(use Main)
(use Talker)

(public
	kingTalker 0
	maliciaTalker 1
	mathildeTalker 2
	spiritTalker 3
	edgerTalker 4
	kid1Talker 5
	kid2Talker 6
	bothKidsTalker 7
	levanterTalker 8
	oberonTalker 9
	titaniaTalker 10
)

(instance kingTalker of KQTalker
	(properties)

	(method (doit)
		(super doit:)
		(if (and gCuees (== gCurRoomNum 2204))
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
	)
)

(instance maliciaTalker of KQTalker
	(properties)
)

(instance mathildeTalker of KQTalker
	(properties)
)

(instance spiritTalker of KQTalker
	(properties)
)

(instance edgerTalker of KQTalker
	(properties)
)

(instance kid1Talker of KQTalker
	(properties)
)

(instance kid2Talker of KQTalker
	(properties)
)

(instance bothKidsTalker of KQTalker
	(properties)
)

(instance levanterTalker of KQTalker
	(properties)
)

(instance oberonTalker of KQTalker
	(properties)
)

(instance titaniaTalker of KQTalker
	(properties)
)

