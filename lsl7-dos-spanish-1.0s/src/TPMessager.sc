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

	(method (nextMsg param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (Str newWith: 4000 {}))
		(= temp3 0)
		(if argc
			(= temp0
				(Message msgGET param1 param2 param3 param4 param5 (temp2 data:))
			)
			(= lastNoun param2)
			(= lastVerb param3)
			(= lastCase param4)
			(= lastMod param1)
		else
			(= temp0
				(Message
					msgGET
					lastMod
					lastNoun
					lastVerb
					lastCase
					curSequence
					(temp2 data:)
				)
			)
		)
		(if
			(and
				temp0
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(= temp6 (TalkerName temp0))
			(= temp3 (Str format: {%s: %s} temp6 temp2))
			(if (!= (= temp1 (self findTalker: temp0)) -1)
				(if (& gMsgType $0002)
					(= temp5 (Str newWith: 1000 {}))
					(Message
						msgGET
						lastMod
						lastNoun
						lastVerb
						lastCase
						curSequence
						(temp5 data:)
					)
					(= temp4 (IntArray with: 0 0 0 0 0))
					(Message 9 (temp4 data:)) ; msgLAST_MESSAGE
					(temp5 dispose:)
				)
				(talkerList add: temp1)
				(temp1 modNum: param1 say: temp3 temp4 self)
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
					(temp4 dispose:)
				)
			else
				(self dispose:)
			)
		else
			(self dispose:)
		)
		(temp2 dispose:)
		(if temp3
			(temp3 dispose:)
		)
	)

	(method (cue param1 &tmp temp0 temp1 temp2)
		(if (and argc param1)
			(= killed 1)
		)
		(if (and killed saveMessages (not oneOnly))
			(= temp2 (Str newWith: 1000 {}))
			(= temp0 (+ curSequence 1))
			(repeat
				(if (and (> lastSequence 0) (> temp0 lastSequence))
					(break)
				)
				(if
					(not
						(= temp1
							(Message
								msgGET
								lastMod
								lastNoun
								lastVerb
								lastCase
								temp0
								(temp2 data:)
							)
						)
					)
					(break)
				)
				(oTextSaver
					rememberMessage: lastMod lastNoun lastVerb lastCase temp0
				)
				(+= temp0 1)
			)
			(temp2 dispose:)
		)
		(if (or oneOnly killed)
			(self dispose:)
		else
			(self nextMsg:)
		)
	)
)

