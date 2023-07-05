;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 858)
(include sci.sh)
(use Main)
(use n013)
(use Table)
(use Feature)
(use Actor)
(use System)

(local
	local0
)

(procedure (localproc_0 &tmp [temp0 200]) ; UNUSED
	(if local0
		(Format @temp0 &rest)
		(proc13_1 @temp0)
	)
)

(class MList of List
	(properties)

	(method (maxElement param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (FirstNode elements))
		(= temp3 0)
		(= temp4 -32768)
		(while temp0
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return temp3)
			)
			(if (> (= temp5 (temp2 perform: param1 &rest)) temp4)
				(= temp3 temp2)
				(= temp4 temp5)
			)
			(= temp0 temp1)
		)
		(return temp3)
	)
)

(class Fighter of Actor
	(properties
		fight 0
		opponent 0
		ticks 0
		lastTicks 0
		idleCycles 0
		parriedCycles 0
		_parts 0
		_techniques 0
		_plan 0
		_technique 0
		_strength 0
	)

	(method (plan param1 &tmp temp0)
		(if argc
			(= temp0 script)
			(if (IsObject _plan)
				(_plan dispose:)
			)
			(if (= _plan param1)
				(_plan init: self &rest)
			)
			(= script temp0)
		)
		(return _plan)
	)

	(method (technique param1 &tmp temp0)
		(if argc
			(= temp0 script)
			(if (IsObject _technique)
				(_technique dispose:)
			)
			(if (= _technique param1)
				(_technique init: self &rest)
			)
			(= script temp0)
		)
		(return _technique)
	)

	(method (doit)
		(super doit: &rest)
		(if ticks
			(if (<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
				(= ticks 0)
				(= lastTicks gGameTime)
			)
			(return)
		)
		(if parriedCycles
			(-- parriedCycles)
		)
		(if _technique
			(_technique doit: &rest)
		else
			(++ idleCycles)
		)
		(if _plan
			(_plan doit: &rest)
		)
	)

	(method (handleEvent event)
		(if (<= _strength 0)
			(return 0)
		)
		(if (super handleEvent: event &rest)
			(return 1)
		)
		(if parriedCycles
			(return 0)
		)
		(if _techniques
			(_techniques firstTrue: #handleEvent event self)
		)
		(if _plan
			(_plan handleEvent: event self)
		)
	)

	(method (doVerb theVerb)
		(if fight
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(if _parts
			(_parts dispose:)
			(= _parts 0)
		)
		(if _techniques
			(_techniques dispose:)
			(= _techniques 0)
		)
		(if _plan
			(_plan dispose:)
			(= _plan 0)
		)
		(super dispose: &rest)
	)

	(method (telegraph param1)
		(opponent notice: param1)
	)

	(method (inflict param1 &tmp temp0 temp1 temp2 temp3)
		(if (== self ((param1 target:) client:))
			(return 0)
		)
		(if (= temp1 (opponent technique:))
			(or (temp1 completed:) (= temp1 0))
		)
		(= temp2 (Random 0 100))
		(= temp3 (fight success: param1 temp1))
		(return
			(cond
				((= temp0 (<= temp2 temp3))
					(opponent suffer: param1)
					1
				)
				((and temp1 (== (temp1 target:) (param1 target:)))
					(= parriedCycles (+ 96 (* 12 (param1 strength:))))
					0
				)
				(else 0)
			)
		)
	)

	(method (parts)
		(if argc
			(= _parts (or _parts (MList new:)))
			(_parts add: &rest eachElementDo: #client self eachElementDo: #init)
		)
		(return _parts)
	)

	(method (techniques)
		(if argc
			(= _techniques (or _techniques (MList new:)))
			(_techniques add: &rest eachElementDo: #client self)
		)
		(return _techniques)
	)

	(method (notice &tmp temp0)
		(if _plan
			(= temp0 script)
			(_plan init: self)
			(= script temp0)
		)
	)

	(method (suffer param1 &tmp temp0 temp1 temp2)
		(if (= temp0 (_parts firstTrue: #suffer param1))
			(-= _strength (param1 strength:))
			(= temp1 (param1 strength:))
			(= temp2 ticks)
			(= ticks (Max parriedCycles ticks temp1))
			(self agonize: param1 temp0)
		)
	)

	(method (agonize))
)

(class Technique of Script
	(properties
		completed 0
		key 0
		dir 0
		view 0
		loop 0
		_strength 0
		_delay 0
		target 0
		claimed 0
		message 0
		type 0
		_success 100
	)

	(method (setTarget param1)
		(if argc
			(= target param1)
		)
	)

	(method (onMe)
		(return (target onMe: &rest))
	)

	(method (dispose &tmp temp0 temp1)
		(= temp0 client)
		(= temp1 (temp0 script:))
		(client _technique: 0 idleCycles: 0)
		(super dispose: &rest)
		(= client temp0)
		(client script: temp1)
	)

	(method (success param1)
		(if argc
			(= _success param1)
		)
		(return _success)
	)

	(method (strength param1)
		(if argc
			(= _strength param1)
		)
		(return _strength)
	)

	(method (delay param1)
		(if argc
			(= _delay param1)
		)
		(return _delay)
	)

	(method (init param1 &tmp temp0 temp1)
		(= lastTicks gGameTime)
		(= completed 0)
		(if (= temp0 (if argc param1 else client))
			(= temp1 (temp0 script:))
		)
		(super init: temp0 &rest)
		(if temp0
			(temp0 script: temp1)
		)
	)

	(method (suffer param1)
		(return
			(if (not (and completed target (target onMe: param1))) 0 else 1)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:) 0)
			(
				(or
					(client parriedCycles:)
					(and (client ticks:) (!= client (target client:)))
				))
			(
				(or
					(and
						key
						(& (event type:) evKEYBOARD)
						(== key (event message:))
					)
					(and
						dir
						(& (event type:) $0040) ; direction
						(== dir (event message:))
					)
					(and (& (event type:) evMOUSEBUTTON) (target onMe: event))
				)
				(if (and (not (client script:)) (!= (client _technique:) self))
					(client technique: self)
				)
				(event claimed: 1)
				1
			)
		)
	)
)

(class Part of Feature
	(properties
		client 0
		_strength 0
	)

	(method (onMe param1)
		(return
			(if (and (IsObject param1) (param1 respondsTo: #target))
				(== self (param1 target:))
			else
				(super onMe: param1 &rest)
			)
		)
	)

	(method (suffer param1)
		(return
			(if (self onMe: param1)
				(-= _strength (param1 strength:))
				1
			)
		)
	)

	(method (strength param1)
		(if argc
			(= _strength param1)
		)
		(return _strength)
	)
)

(class Fight of Script
	(properties
		goodGuy 0
		badGuy 0
		chanceTable 0
	)

	(method (init param1 param2 param3 param4)
		(if (not goodGuy)
			((= goodGuy param2) fight: self opponent: param3)
		)
		(if (not badGuy)
			((= badGuy param3) fight: self opponent: param2)
		)
		(if argc
			(super init: param1 &rest)
		)
		(goodGuy init:)
		(badGuy init:)
		(if (not chanceTable)
			((= chanceTable (Table new:))
				data: param4
				columns: ((goodGuy techniques:) size:)
				rows: ((badGuy techniques:) size:)
			)
		)
	)

	(method (dispose)
		(if chanceTable
			(chanceTable dispose:)
			(= chanceTable 0)
		)
		(= badGuy (= goodGuy 0))
		(super dispose: &rest)
	)

	(method (success param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 3] temp8 temp9 temp10)
		(= temp0
			(if (or (< argc 2) (not param2))
				(param1 success:)
			else
				(= temp1 (goodGuy techniques:))
				(= temp2 (badGuy techniques:))
				(if (== goodGuy (param1 client:))
					(= temp3 param1)
					(= temp4 param2)
				else
					(= temp3 param2)
					(= temp4 param1)
				)
				(= temp9 (temp2 indexOf: temp4))
				(= temp10 (temp1 indexOf: temp3))
				(= temp8 (chanceTable at: temp9 temp10))
				(/ (* (param1 success:) (- 100 temp8)) 100)
			)
		)
	)
)

