;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64029)
(include sci.sh)
(use Main)
(use oMessager)
(use Str)
(use Array)
(use Messager)

(class TPMessager of Messager
	(properties
		oTextSaver 0
		saveMessages 0
		lastNoun 0
		lastVerb 0
		lastCase 0
		lastMod 0
	)

	(method (sayNoSave)
		(if saveMessages
			(= saveMessages 0)
			(self say: &rest)
			(= saveMessages 1)
		else
			(self say: &rest)
		)
	)

	(method (nextMsg theMod theNoun theVerb theCase theSeq &tmp aTalker theBuf labelBuf msgkey)
		(= theBuf (Str newWith: 1000 {}))
		(= labelBuf 0)
		(if argc
			(= aTalker
				(Message msgGET theMod theNoun theVerb theCase theSeq (theBuf data:))
			)
			(= lastNoun theNoun)
			(= lastVerb theVerb)
			(= lastCase theCase)
			(= lastMod theMod)
		else
			(= aTalker
				(Message
					msgGET
					lastMod
					lastNoun
					lastVerb
					lastCase
					curSequence
					(theBuf data:)
				)
			)
		)
		(if
			(and
				aTalker
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(= labelBuf (Str format: {%s: %s} (TalkerName aTalker) theBuf))
			(if (!= (= aTalker (self findTalker: aTalker)) -1)
				(if (& gMsgType $0002)
					(= msgkey (IntArray with: 0 0 0 0 0))
					(Message 9 (msgkey data:)) ; msgLAST_MESSAGE
				)
				(talkerList add: aTalker)
				(aTalker modNum: theMod say: labelBuf msgkey self)
				(if (and saveMessages oTextSaver)
					(oTextSaver
						rememberMessage:
							lastMod
							lastNoun
							lastVerb
							lastCase
							curSequence
					)
				)
				(++ curSequence)
				(if (& gMsgType $0002)
					(msgkey dispose:)
				)
			else
				(self dispose:)
			)
		else
			(self dispose:)
		)
		(theBuf dispose:)
		(if labelBuf
			(labelBuf dispose:)
		)
	)

	(method (cue killIt &tmp curSave aTalker theBuf)
		(if (and argc killIt)
			(= killed 1)
		)
		(if (and killed saveMessages (not oneOnly))
			(= theBuf (Str newWith: 1000 {}))
			(= curSave (+ curSequence 1))
			(repeat
				(if (and (> lastSequence 0) (> curSave lastSequence))
					(break)
				)
				(if
					(not
						(= aTalker
							(Message
								msgGET
								lastMod
								lastNoun
								lastVerb
								lastCase
								curSave
								(theBuf data:)
							)
						)
					)
					(break)
				)
				(oTextSaver
					rememberMessage: lastMod lastNoun lastVerb lastCase curSave
				)
				(+= curSave 1)
			)
			(theBuf dispose:)
		)
		(if (or oneOnly killed)
			(self dispose:)
		else
			(self nextMsg:)
		)
	)
)

