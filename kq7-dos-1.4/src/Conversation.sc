;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64925)
(include sci.sh)
(use Main)
(use Print)
(use System)

(class MessageObj of Obj
	(properties
		modNum -1
		noun 0
		verb 0
		case 0
		sequence 0
		whoSays 0
		client 0
		caller 0
		font 0
		x 0
		y 0
	)

	(method (showSelf)
		(= whoSays
			(gMessager
				findTalker:
					(Message
						msgGET
						modNum
						noun
						verb
						case
						(if sequence sequence else 1)
					)
			)
		)
		(cond
			((== whoSays -1)
				(caller cue:)
			)
			((not whoSays)
				(Print
					addTextF:
						{<MessageObj> Message not found: %d - %d, %d, %d, %d}
						modNum
						noun
						verb
						case
						sequence
					init:
				)
			)
			(else
				(if font
					(whoSays font: font)
				)
				(if (or x y)
					(whoSays x: x y: y)
				)
				(gMessager say: noun verb case sequence caller modNum)
			)
		)
	)
)

(class Conversation of List
	(properties
		script 0
		curItem -1
		caller 0
	)

	(method (init who)
		(= curItem -1)
		(if (and argc who)
			(= caller who)
		)
		(gTheDoits add: self)
		(self cue:)
	)

	(method (dispose &tmp toCall)
		(self eachElementDo: #perform cleanCode)
		(gTheDoits delete: self)
		(if script
			(= script 0)
		)
		(= toCall caller)
		(super dispose:)
		(if toCall
			(toCall cue:)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (cue killIt &tmp obj theClient)
		(if (or (and argc killIt) (== (++ curItem) size))
			(self dispose:)
		else
			(= obj (self at: curItem))
			(cond
				((obj isKindOf: MessageObj)
					(obj caller: self showSelf:)
				)
				((obj isKindOf: Script)
					(self setScript: obj self)
				)
				(else
					(obj doit: self)
				)
			)
		)
	)

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (load theConv &tmp theMod theNoun theVerb theCase theSeq theX theY theFont i)
		(= theMod (theConv at: 0))
		(= theNoun (theConv at: 1))
		(= theVerb (theConv at: 2))
		(= theCase (theConv at: 3))
		(= theSeq (theConv at: 4))
		(= theX (theConv at: 5))
		(= theY (theConv at: 6))
		(= theFont (theConv at: 7))
		(= i 7)
		(while theMod
			(if (== theMod -1)
				(= theMod gCurRoomNum)
			)
			(self add: theMod theNoun theVerb theCase theSeq theX theY theFont)
			(= theMod (theConv at: (++ i)))
			(= theNoun (theConv at: (++ i)))
			(= theVerb (theConv at: (++ i)))
			(= theCase (theConv at: (++ i)))
			(= theSeq (theConv at: (++ i)))
			(= theX (theConv at: (++ i)))
			(= theY (theConv at: (++ i)))
			(= theFont (theConv at: (++ i)))
		)
	)

	(method (add args &tmp aMod aNoun aVerb aCase aSeq theX theY aFont)
		(= aMod (= aNoun (= aVerb (= aCase (= aSeq 0)))))
		(= theX (= theY (= aFont 0)))
		(if (> argc 1)
			(if (== (= aMod [args 0]) -1)
				(= aMod gCurRoomNum)
			)
			(if (> argc 1)
				(= aNoun [args 1])
				(if (> argc 2)
					(= aVerb [args 2])
					(if (> argc 3)
						(= aCase [args 3])
						(if (> argc 4)
							(= aSeq [args 4])
							(if (> argc 5)
								(= theX [args 5])
								(if (> argc 6)
									(= theY [args 6])
									(if (> argc 7)
										(= aFont [args 7])
									)
								)
							)
						)
					)
				)
			)
			(if (> argc 1)
				(super
					add:
						((MessageObj new:)
							modNum: aMod
							noun: aNoun
							verb: aVerb
							case: aCase
							sequence: aSeq
							x: theX
							y: theY
							font: aFont
							yourself:
						)
				)
			)
		else
			(super add: args &rest)
		)
	)
)

(instance cleanCode of Code
	(properties)

	(method (doit obj &tmp tkr)
		(if (obj isKindOf: Script)
			(obj caller: 0)
		)
		(if (obj isKindOf: MessageObj)
			(= tkr (obj whoSays:))
			(tkr dispose: 1)
		)
	)
)

