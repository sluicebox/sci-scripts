;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use Sound)
(use Game)

(public
	regDwarfHouse 0
)

(synonyms
	(dwarf fuck man person)
)

(instance theSound of Sound
	(properties
		number 62
		loop -1
	)
)

(instance regDwarfHouse of Rgn
	(properties)

	(method (init)
		(if initialized
			(return)
		)
		(super init:)
		(Load rsVIEW 290)
		(Load rsSOUND 62)
		(= global189 (= keep 1))
		(theSound owner: self init:)
	)

	(method (dispose)
		(if (not keep)
			(= global189 0)
			(super dispose:)
		)
	)

	(method (notify param1)
		(if param1
			(theSound play:)
		else
			(theSound client: 0 stop:)
		)
	)
)

