;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 925)
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

	(method (showSelf &tmp [temp0 40])
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
		(if (!= whoSays -1)
			(if (not (IsObject whoSays))
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
				(= gQuit 1)
			else
				(if font
					(whoSays font: font)
				)
				(if (or x y)
					(whoSays x: x y: y)
				)
				(gMessager say: noun verb case sequence caller modNum)
			)
		else
			(caller cue:)
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
		(if (and argc (IsObject who))
			(= caller who)
		)
		(gTheDoits add: self)
		(self cue:)
	)

	(method (dispose &tmp toCall)
		(self eachElementDo: #perform cleanCode)
		(gTheDoits delete: self)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if script
			(= script 0)
		)
		(= toCall caller)
		(super dispose:)
		(if toCall
			(= caller 0)
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
				((IsObject obj)
					(obj doit: self)
				)
				(else
					(self cue:)
				)
			)
		)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(if newScript
			(newScript init: self &rest)
		)
	)

	(method (load theConv &tmp theMod theNoun theVerb theCase theSeq theX theY theFont i)
		(= theMod (WordAt theConv 0))
		(= theNoun (WordAt theConv 1))
		(= theVerb (WordAt theConv 2))
		(= theCase (WordAt theConv 3))
		(= theSeq (WordAt theConv 4))
		(= theX (WordAt theConv 5))
		(= theY (WordAt theConv 6))
		(= theFont (WordAt theConv 7))
		(= i 7)
		(while theMod
			(if (== theMod -1)
				(= theMod gCurRoomNum)
			)
			(self add: theMod theNoun theVerb theCase theSeq theX theY theFont)
			(= theMod (WordAt theConv (++ i)))
			(= theNoun (WordAt theConv (++ i)))
			(= theVerb (WordAt theConv (++ i)))
			(= theCase (WordAt theConv (++ i)))
			(= theSeq (WordAt theConv (++ i)))
			(= theX (WordAt theConv (++ i)))
			(= theY (WordAt theConv (++ i)))
			(= theFont (WordAt theConv (++ i)))
		)
	)

	(method (add args &tmp aMod aNoun aVerb aCase aSeq theX theY aFont)
		(= aMod (= aNoun (= aVerb (= aCase (= aSeq 0)))))
		(= theX (= theY (= aFont 0)))
		(if (and argc (not (IsObject [args 0])))
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
			(if (not (IsObject [args 0]))
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
		(if
			(and
				(obj isKindOf: MessageObj)
				(IsObject (= tkr (obj whoSays:)))
				(tkr underBits:)
			)
			(tkr dispose: 1)
		)
	)
)

