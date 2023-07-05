;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64924)
(include sci.sh)
(use Main)
(use GK2Ego)
(use Str)
(use Array)
(use Print)
(use System)

(local
	local0
	local1
	local2
)

(class Messager of Obj
	(properties
		caller 0
		disposeWhenDone 1
		oneOnly 0
		killed 0
		disableIconBar 1
		oldIconBarState 0
		curSequence 0
		lastSequence 0
	)

	(method (dispose)
		(if (and local0 local2)
			(local2 dispose:)
			(= local2 0)
		)
		(if (talkerSet size:)
			(talkerSet dispose:)
		)
		(= lastSequence 0)
		(if (and gTheIconBar disableIconBar)
			(gTheIconBar state: oldIconBarState)
			(= oldIconBarState 0)
		)
		(if caller
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees
				add:
					((Cue new:)
						cuee: caller
						cuer: self
						register: killed
						yourself:
					)
			)
		)
		(super dispose:)
	)

	(method (cue killIt)
		(if (and argc killIt)
			(= killed 1)
		)
		(if (or oneOnly killed)
			(self dispose:)
		else
			(self nextMsg:)
		)
	)

	(method (say args &tmp aNoun aVerb aCase aMod)
		(= aNoun (= aVerb (= aCase (= curSequence (= caller 0)))))
		(= oneOnly (= killed 0))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(= aNoun [args 0])
		(if (> argc 1)
			(= aVerb [args 1])
		)
		(if (> argc 2)
			(= aCase [args 2])
		)
		(if (and (> argc 3) [args 3])
			(= oneOnly 1)
			(= curSequence [args 3])
		else
			(= curSequence 1)
		)
		(if (> argc 4)
			(= caller [args 4])
		)
		(if (> argc 5)
			(= aMod [args 5])
		else
			(= aMod gCurRoomNum)
		)
		(if (not (and gMsgType (Message msgGET aMod aNoun aVerb aCase curSequence)))
			(Print
				addTextF:
					{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
					aMod
					aNoun
					aVerb
					aCase
					curSequence
				init:
			)
			(= aMod 64994)
			(= aNoun 12)
			(= aVerb (= aCase 0))
			(= curSequence 1)
		)
		(self nextMsg: aMod aNoun aVerb aCase curSequence)
	)

	(method (sayRange args &tmp aNoun aVerb aCase aMod)
		(= aNoun (= aVerb (= aCase (= curSequence (= caller 0)))))
		(= oneOnly (= killed 0))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(= aNoun [args 0])
		(if (> argc 1)
			(= aVerb [args 1])
		)
		(if (> argc 2)
			(= aCase [args 2])
		)
		(= oneOnly 1)
		(if (and (> argc 3) [args 3])
			(= curSequence [args 3])
		else
			(= curSequence 1)
		)
		(if (and (> argc 4) [args 4])
			(= oneOnly 0)
			(= lastSequence [args 4])
		else
			(= lastSequence curSequence)
		)
		(if (> argc 5)
			(= caller [args 5])
		)
		(if (> argc 6)
			(= aMod [args 6])
		else
			(= aMod gCurRoomNum)
		)
		(if (not (and gMsgType (Message msgGET aMod aNoun aVerb aCase curSequence)))
			(Print
				addTextF:
					{<Messager>\n\tmsgType set to 0 or\n\t%d: %d, %d, %d, %d not found}
					aMod
					aNoun
					aVerb
					aCase
					curSequence
				init:
			)
			(= aMod 64994)
			(= aNoun 12)
			(= aVerb (= aCase 0))
			(= curSequence 1)
		)
		(self nextMsg: aMod aNoun aVerb aCase curSequence)
	)

	(method (sayNext aCaller)
		(= caller (= oneOnly (= killed 0)))
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(if argc
			(= caller aCaller)
		)
		(self nextMsg:)
	)

	(method (sayFormat whoCares theTalker ctrlString args &tmp len buffer aTalker)
		(if (and gTheIconBar disableIconBar (not oldIconBarState))
			(= oldIconBarState (gTheIconBar state:))
			(gTheIconBar disable:)
		)
		(= aTalker (self findTalker: theTalker))
		(= len (FindFormatLen ctrlString args &rest))
		(= caller whoCares)
		(= oneOnly 1)
		(= buffer (Str newWith: len {}))
		(buffer format: ctrlString args &rest)
		(aTalker say: buffer self)
		(buffer dispose:)
	)

	(method (nextMsg theMod theNoun theVerb theCase theSeq &tmp temp0 temp1 temp2 temp3)
		(= temp3 0)
		(= gMsgType 2)
		(= temp1 (Str newWith: 400 {}))
		(if argc
			(= temp0
				(Message msgGET theMod theNoun theVerb theCase theSeq (temp1 data:))
			)
		else
			(= temp0 (Message msgNEXT (temp1 data:)))
		)
		(if (& gMsgType $0002)
			(= temp2 (IntArray with: 0 0 0 0 0))
			(Message 9 (temp2 data:)) ; msgLAST_MESSAGE
		)
		(if
			(and
				temp0
				(or
					(not lastSequence)
					(and lastSequence (<= curSequence lastSequence))
				)
			)
			(if (!= (= temp0 (self findTalker: temp0)) -1)
				(talkerSet add: temp0)
				(if (& gMsgType $0002)
					(if
						(and
							(OneOf (gGame printLang:) 351)
							(not
								(and
									(gPlanes contains: (ScriptID 20 1)) ; invPlane
									(or
										(OneOf
											(= temp3 ((ScriptID 20 1) picture:)) ; invPlane
											13020
											13064
										)
										(OneOf
											temp3
											14010
											14011
											14230
											14231
											14232
											14233
										)
										(OneOf
											temp3
											14234
											14370
											14371
											14402
										)
										(OneOf
											temp3
											14403
											14404
											14440
											14441
											14442
											14443
										)
										(OneOf
											temp3
											14444
											14445
											14446
											14447
											14448
											14449
										)
										(OneOf
											temp3
											14570
											14571
											14572
											14573
											14654
										)
										(OneOf
											temp3
											14574
											14575
											14650
											14651
											14652
											14653
										)
									)
								)
							)
						)
						(= local0 1)
						(if
							(or
								(and (== temp3 13036) (< curSequence 6))
								(and (== temp3 14470) (< curSequence 4))
								(and (== temp3 14401) (< curSequence 3))
								(and (== temp3 14240) (== gEgo GraceEgo))
								(and (== temp3 14241) (== gEgo GraceEgo))
								(and (== temp3 14250) (== gEgo GraceEgo))
								(and (== temp3 14260) (== gEgo GraceEgo))
								(and (== temp3 14261) (== gEgo GraceEgo))
							)
							(= local0 0)
						)
					else
						(= local0 0)
						(if (and (== temp3 14570) (== theNoun 161))
							(= local0 1)
						)
					)
					(if local0
						(if local2
							(local2 dispose:)
							(= local2 0)
						)
						(= local1 (Print new:))
						(local1
							font: 51
							back: 4
							fore: 14
							x: 60
							y: 360
							modeless: 2
							addText: (temp1 data:)
							init:
						)
						(= local2 (local1 dialog:))
						(gPrints delete: local1)
					)
					(if (not (temp0 say: temp2 self))
						(temp0
							say: temp1 self theMod theNoun theVerb theCase theSeq
						)
					)
				else
					(temp0
						modNum: theMod
						say: temp1 self theMod theNoun theVerb theCase theSeq
					)
				)
				(++ curSequence)
			else
				(self dispose:)
			)
		else
			(self dispose:)
		)
		(if (& gMsgType $0002)
			(temp2 dispose:)
		)
		(temp1 dispose:)
	)

	(method (findTalker)
		(Print
			width: 200
			addText:
				{<Messager findTalker:>\n\tCan't find talker or\n\tfindTalker method not over-ridden}
			init:
		)
		(return gNarrator)
	)
)

(instance talkerSet of Set
	(properties)

	(method (dispose)
		(self
			eachElementDo: #caller 0
			eachElementDo: #dispose (gMessager disposeWhenDone:)
			release:
		)
		(super dispose:)
	)
)

