;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use KQ6Print)
(use n913)
(use Game)
(use User)
(use System)

(public
	KQ6Room 0
)

(local
	local0
)

(procedure (localproc_0)
	(return
		(switch gCurRoomNum
			(160 160)
			(290 34)
			(320 64)
			(390 134)
			(410 154)
			(420 164)
			(440 184)
			(461 5) ; blackWidowInset
			(740 228)
			(750 238)
			(790 22)
			(else 0)
		)
	)
)

(class NewRoomCue of Cue
	(properties)

	(method (doit)
		(gSet delete: self)
		(if (gSet isEmpty:)
			(gSet dispose:)
			(= gSet 0)
		)
		(cuee newRoomCue: register)
		(self dispose:)
	)
)

(class KQ6Room of Rm
	(properties
		horizon 80
		walkOffEdge 0
		autoLoad 1
	)

	(method (translateVerb param1)
		(if (not (OneOf param1 3 1 4 2))
			(return 0)
		else
			(return 0)
		)
	)

	(method (init)
		(= local0 0)
		(super init: &rest)
		(if (and (& gMsgType $0001) autoLoad)
			(if (== modNum -1)
				(= modNum gCurRoomNum)
			)
			(Load rsMESSAGE modNum)
			(Lock rsMESSAGE modNum 1)
		)
		(if (IsFlag 103)
			(gGame handsOff:)
			(ClearFlag 103)
			(self setScript: (ScriptID 89 0)) ; poofInScript
		)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(not script)
				(not walkOffEdge)
				(= temp0 ((User alterEgo:) edgeHit:))
				(not (self edgeToRoom: temp0))
			)
			((User alterEgo:) edgeHit: EDGE_NONE setMotion: 0)
			(switch temp0
				(3
					(gEgo y: 188)
				)
				(1
					(gEgo y: (+ horizon 1))
				)
				(4
					(gEgo x: 1)
				)
				(2
					(gEgo x: 318)
				)
			)
		)
		(cond
			(script
				(script doit:)
			)
			(local0 0)
			((= temp0 (self edgeToRoom: ((User alterEgo:) edgeHit:)))
				(self newRoom: temp0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if (not local0)
			(gGame handsOff:)
			(Lock rsMESSAGE modNum 0)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (not gSet)
				(= gSet (Set new:))
			)
			(gSet
				add:
					((NewRoomCue new:)
						cuee: self
						cuer: self
						register: newRoomNumber
						yourself:
					)
			)
			(= local0 1)
		)
	)

	(method (newRoomCue)
		(super newRoom: &rest)
	)

	(method (doVerb theVerb)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(return
			(if
				(and
					(== (gKq6ApproachCode doit: theVerb) -32768)
					(Message msgGET modNum noun 0 0 1)
				)
				(gMessager say: noun 0 0 0 0 modNum)
				1
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (setScript param1 &tmp temp0)
		(cond
			((IsObject param1)
				(super setScript: param1 &rest)
			)
			((!= (gEgo view:) 900)
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 7 0 16 1 0 0 0 ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
					init:
				)
			)
			(
				(or
					(and (gEgo script:) (== param1 905))
					(and (self script:) (== param1 905))
					(and (== param1 905) (== gCurRoomNum 480) (gEgo script:))
				)
				(KQ6Print
					font: gUserFont
					posn: -1 10
					say: 0 7 0 16 1 0 0 0 ; "Alexander is a little busy for that right now. Perhaps he should try it again later."
					init:
				)
			)
			((OneOf param1 87 85 88 90 190 915 92 93 97 96 905)
				(cond
					(
						(OneOf
							gCurRoomNum
							160
							290
							320
							390
							410
							420
							440
							600
							630
							640
							650
							660
							670
							680
							690
							740
							750
							790
							461 ; blackWidowInset
						)
						(cond
							(
								(OneOf
									gCurRoomNum
									600
									630
									640
									650
									660
									670
									680
									690
								)
								(KQ6Print
									font: gUserFont
									posn: -1 10
									say: 0 0 0 88 1 0 0 899 ; "The Realm of the Dead is a very dangerous place! There's no time for that here!"
									init:
								)
							)
							((== gCurRoomNum 461) ; blackWidowInset
								(KQ6Print
									font: gUserFont
									posn: -1 10
									say: 0 0 0 5 1 0 0 899 ; "Alexander is a bit busy with the black widow at the moment! Try that again later!"
									init:
								)
							)
							((= temp0 (localproc_0))
								(KQ6Print
									font: gUserFont
									posn: -1 10
									say: 0 0 0 gCurRoomNum 1 0 0 899
									init:
								)
							)
						)
					)
					((self scriptCheck: param1)
						(super setScript: (ScriptID param1) &rest)
					)
				)
			)
			(else
				(super setScript: (ScriptID param1) &rest)
			)
		)
	)

	(method (scriptCheck)
		(return 1)
	)
)

