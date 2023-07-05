;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm18 0
)

(local
	local0
	local1
	local2
	local3 = 25
	[local4 25] = [0 1 1 2 3 4 5 5 5 6 6 6 7 7 7 7 8 8 8 9 9 10 10 10 11]
	local29 = 1
)

(instance tempList of List
	(properties)
)

(instance goodList of List
	(properties)
)

(instance rm18 of LBRoom
	(properties
		picture 18
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(LoadMany rsVIEW 18)
		(super init:)
		(gGame handsOn:)
		(gTheIconBar disable: 0 1 3 4 5 6 7)
		(goodList add:)
		(tempList add:)
		(= temp2 -32)
		(= temp3 46)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(tempList add: ((egyptProp new:) cel: temp0 yourself:))
		)
		(while (tempList size:)
			(= temp0 (Random 0 (- (tempList size:) 1)))
			(= temp1 (tempList at: temp0))
			(goodList add: (temp1 x: (+= temp2 48) y: temp3 yourself:))
			(if (== (goodList size:) 6)
				(= temp2 -32)
				(= temp3 111)
			)
			(tempList delete: temp1)
		)
		(gGame handsOff:)
		(self setScript: sInitEm)
	)

	(method (dispose)
		(goodList release: dispose:)
		(tempList release: dispose:)
		(super dispose:)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance sInitEm of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				((goodList firstTrue: #perform checkCel register)
					init:
					setScript: sFlipIt self register
				)
			)
			(2
				(if (< (++ register) (goodList size:))
					(= state 0)
					(= cycles 1)
				else
					(= next sAskIt)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFlipIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (client cel:))
				(client loop: 1 cel: 0)
				(client setCycle: End self)
			)
			(1
				(gGameMusic2 number: 55 flags: 1 loop: 1 play:)
				(client loop: 0 cel: local0 addToPic:)
				(if (== register 11)
					(gGame handsOn: 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sAskIt of Script
	(properties)

	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if
					(or
						(== (= local1 (Random 1 local3)) global146)
						(== local1 global147)
					)
					(-- state)
					(self cue:)
				else
					(switch gAct
						(1
							(= global146 local1)
							(= local2 230)
						)
						(3
							(= global147 local1)
							(= local2 355)
						)
						(5
							(= local2 420)
						)
					)
				)
				(= seconds 2)
			)
			(2
				(Message msgGET 18 2 0 0 local1 @temp0)
				(Display @temp0 dsCOORD 15 15 dsFONT 61 dsWIDTH 280 dsALIGN alCENTER dsCOLOR global151)
				(Display @temp0 dsCOORD 15 15 dsFONT 60 dsWIDTH 280 dsALIGN alCENTER dsCOLOR 23)
			)
			(3
				(if local29
					(SetFlag 34)
				else
					(ClearFlag 34)
				)
				(gCurRoom newRoom: local2)
			)
		)
	)
)

(instance egyptProp of Prop
	(properties
		view 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel [local4 (- local1 1)])
					(sAskIt cue:)
				else
					(= local29 0)
					(sAskIt cue:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance checkCel of Code
	(properties)

	(method (doit param1 param2)
		(return (== (param1 cel:) param2))
	)
)

