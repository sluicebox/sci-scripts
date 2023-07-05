;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64924)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use WriteFeature)
(use Menu)
(use System)

(class MessageString of Str
	(properties
		audKeys 0
		noun -1
		case -1
		modNum -1
		sequence -1
		talker -1
		verb -1
	)

	(method (new &tmp temp0)
		(= temp0 (super new: &rest))
		(temp0 audKeys: (IntArray with: 0 0 0 0 0))
		(return temp0)
	)

	(method (dispose)
		(if audKeys
			(audKeys dispose:)
			(= audKeys 0)
		)
		(super dispose: &rest)
	)

	(method (doit param1 param2 param3 param4 param5)
		(if (and argc (!= argc 5))
			(PrintDebug {Invalid argc(%d) for Message\n} argc)
			(Empty self)
		)
		(= talker
			(if argc
				(Message msgGET param1 param2 param3 param4 param5 data)
			else
				(Message msgNEXT data)
			)
		)
		(if talker
			(if (not audKeys)
				(= audKeys (IntArray with: 0 0 0 0 0))
			)
			(Message 9 (KArray 9 audKeys)) ; msgLAST_MESSAGE, ArrayGetData
			(= modNum (audKeys at: 0))
			(= noun (audKeys at: 1))
			(= verb (audKeys at: 2))
			(= case (audKeys at: 3))
			(= sequence (audKeys at: 4))
		)
		(return talker)
	)
)

(class Messager of Obj
	(properties
		state 2
		caller 0
		message 0
		sequence 0
		lastSequence 32767
		talkers 0
	)

	(method (init)
		(= talkers (TalkerSet new:))
		(= message (MessageString new:))
		(&= state $fffb)
	)

	(method (dispose)
		(if talkers
			(talkers dispose: (& state $0002))
			(= talkers 0)
		)
		(= lastSequence 32767)
		(if caller
			(Cue new: caller (& state $0004))
		)
		(if message
			(message dispose:)
			(= message 0)
		)
		(super dispose:)
	)

	(method (cue killIt)
		(if (and argc killIt)
			(| state $0004)
		)
		(if
			(or
				(& state $0004)
				(> (++ sequence) lastSequence)
				(not (message doit:))
			)
			(self dispose:)
		else
			(self doit:)
		)
	)

	(method (say args &tmp aNoun aVerb aCase aMod)
		(if (not argc)
			(PrintDebug {Noun required for messager say\n})
			(Empty)
		)
		(if (not message)
			(self init:)
		)
		(= aNoun (= aVerb (= aCase (= sequence (= caller 0)))))
		(= aNoun [args 0])
		(if (> argc 1)
			(= aVerb [args 1])
		)
		(if (> argc 2)
			(= aCase [args 2])
		)
		(if (and (> argc 3) (= sequence [args 3]))
			(= lastSequence sequence)
		else
			(= sequence 1)
		)
		(if (> argc 4)
			(= caller [args 4])
		)
		(= aMod (if (> argc 5) [args 5] else gCurRoomNum))
		(if (message doit: aMod aNoun aVerb aCase sequence)
			(self doit:)
		else
			(PrintDebug
				{Message not found:m%d n%d v%d c%d s%d\n}
				aMod
				aNoun
				aVerb
				aCase
				sequence
			)
		)
	)

	(method (sayRange args &tmp aNoun aVerb aCase aMod)
		(if (< argc 5)
			(PrintDebug {Invalid argc(%d) for sayRange\n} argc)
			(Empty self)
		)
		(if (not message)
			(self init:)
		)
		(= aNoun (= aVerb (= aCase (= sequence (= caller 0)))))
		(= aNoun [args 0])
		(= aVerb [args 1])
		(= aCase [args 2])
		(= sequence [args 3])
		(= lastSequence [args 4])
		(if (not lastSequence)
			(= lastSequence 32767)
		)
		(if (> argc 5)
			(= caller [args 5])
		)
		(= aMod (if (> argc 6) [args 6] else gCurRoomNum))
		(if (message doit: aMod aNoun aVerb aCase sequence)
			(self doit:)
		else
			(PrintDebug
				{Message not found:m%d n%d v%d c%d s%d\n}
				aMod
				aNoun
				aVerb
				aCase
				sequence
			)
		)
	)

	(method (doit &tmp temp0)
		(if (= temp0 (self findTalker: (message talker:)))
			(temp0 say: message self)
		else
			(self dispose:)
		)
	)

	(method (findTalker)
		(PrintDebug {FindTalker not re-defined!\n})
		(return 0)
	)
)

(class TalkerSet of Set
	(properties
		talker 0
	)

	(method (dispose param1)
		(= talker 0)
		(self eachElementDo: #caller 0)
		(if (not param1)
			(self release:)
		)
		(super dispose: &rest)
	)

	(method (add param1)
		(= talker param1)
		(super add: talker &rest)
	)
)

