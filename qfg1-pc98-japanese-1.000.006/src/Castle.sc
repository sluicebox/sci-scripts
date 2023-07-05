;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Main)
(use Game)

(public
	Castle 0
)

(local
	local0
)

(instance Castle of Locale
	(properties)

	(method (handleEvent event &tmp [temp0 4])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							((Said '/castle')
								(HighPrint 807 0) ; "The great house of Baron Stefan von Spielburg rises on a low hillock over the courtyard and castle walls."
							)
							((Said '/tower')
								(HighPrint 807 1) ; "There are guard towers at regular intervals around the castle wall."
							)
							((Said '/gate,gatehouse')
								(HighPrint 807 2) ; "The gatehouse is a massive structure with a portcullis closing off access to the castle."
							)
							((Said '/portcullis')
								(HighPrint 807 3) ; "It's a gate that raises and lowers."
							)
							((Said '/wall,parapet,parapet,aisle')
								(HighPrint 807 4) ; "The castle walls are thick and massive. There is a walkway around the rampart for the guards to patrol"
							)
							((Said '/courtyard')
								(HighPrint 807 5) ; "The main courtyard is a broad, grassy area with a large octagonal area of flagstone paving in the center."
							)
							((Said '/flagstone')
								(switch local0
									(0
										(HighPrint 807 6) ; "The flagstones are from a rock quarry in eastern Germany."
										(++ local0)
									)
									(1
										(HighPrint 807 7) ; "Well...maybe the flagstones are from western Germany."
										(++ local0)
									)
									(2
										(HighPrint 807 8) ; "Flagstones from Europe?"
										(++ local0)
									)
									(3
										(HighPrint 807 9) ; "Granite from our very own moutains?"
										(++ local0)
									)
									(4
										(HighPrint 807 10) ; "I don't know!"
										(= local0 0)
									)
								)
							)
						)
					)
				)
			)
		)
	)
)

