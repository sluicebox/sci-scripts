;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	phone 0
)

(synonyms
	(talk tell interrogate ask talk)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	[local11 160]
	[local171 10]
	local181
)

(procedure (localproc_0 param1)
	(Ring loop: param1 play:)
)

(procedure (localproc_1)
	(Busy loop: 6 play:)
)

(procedure (localproc_2 param1 &tmp temp0)
	(if (== argc 1)
		(= temp0 param1)
	else
		(= temp0 (Random 0 100))
	)
	(cond
		((<= temp0 40)
			(localproc_1)
			(Print 12 104) ; "The phone is busy."
			(Busy stop:)
		)
		((<= temp0 95)
			(localproc_0 5)
			(Print 12 105) ; "You suspect no one is there and hang up."
			(Ring stop:)
		)
		(else
			(Print 12 106) ; "....We're sorry. That number cannot be completed as dialed. Please try again."
		)
	)
	(gCurRoom setScript: phoneNumber)
)

(procedure (localproc_3)
	(local2 posn: 30 1000)
	(local3 posn: 60 1000)
	(RedrawCast)
	(clr)
	(= local9 4)
	(Format @local11 12 107) ; "CLICK"
	(proc0_19 local2 doTalk 2)
)

(procedure (localproc_4)
	(clr)
	(Format @local11 &rest)
	(proc0_19 local1 doEgoTalk)
)

(procedure (localproc_5)
	(clr)
	(= local9 0)
	(Format @local11 &rest)
	(proc0_19 local2 doTalk)
)

(procedure (localproc_6 param1)
	(= local11 0)
	(if (> (param1 message:) 32)
		(Format @local11 12 108 (param1 message:)) ; "%c"
	)
	(repeat
		(if (Print 12 109 #at 20 120 #edit @local11 25) ; "Enter input: (ESC to disconnect)"
			(if (Parse @local11 myEvent)
				(param1 type: 128)
				(param1 claimed: 0)
				(gCurRoom handleEvent: param1)
				(break)
			)
		else
			(localproc_4 12 107)
			((gCurRoom script:) changeState: 999)
			(break)
		)
	)
)

(instance myEvent of Event
	(properties)
)

(instance Ring of Sound
	(properties
		number 44
	)
)

(instance Busy of Sound
	(properties
		number 45
	)
)

(instance phone of Rm
	(properties
		picture 444
		style 6
	)

	(method (init)
		(Load rsVIEW 444)
		(Load rsVIEW 445)
		(Load rsSOUND 44)
		(Load rsSOUND 45)
		(super init:)
		(= local171 0)
		((= local0 (Act new:))
			view: 444
			setLoop: 0
			cel: 0
			posn: 245 167
			setPri: 1
			ignoreActors:
			init:
		)
		((= local1 (Act new:))
			view: 445
			setLoop: 0
			cel: 0
			ignoreActors:
			posn: 240 151
			init:
		)
		((= local2 (Act new:))
			view: 444
			loop: 1
			cel: 0
			setPri: 1
			ignoreActors:
			posn: 60 1000
			init:
		)
		((= local3 (Act new:))
			view: 445
			loop: 1
			cel: 0
			ignoreActors:
			posn: 60 1000
			init:
		)
		(HandsOff)
		(gCurRoom setScript: phoneNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(super handleEvent: event)
			)
			(evSAID
				(cond
					((Said '/bye')
						(switch (Random 0 2)
							(0
								(localproc_4 12 0)
							)
							(1
								(localproc_4 12 1)
							)
							(else
								(localproc_4 12 2)
							)
						)
						((gCurRoom script:) changeState: 999)
					)
					((Said '(hang<up),disconnect')
						((gCurRoom script:) changeState: 999)
					)
					((or (Said 'fuck,shit') (Said '/fuck,shit'))
						((gCurRoom script:) changeState: 999)
					)
					(else
						(super handleEvent: event)
					)
				)
			)
		)
	)
)

(instance phoneNumber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(= seconds 2)
			)
			(1
				(User canInput: 1)
				(= local11 0)
				(repeat
					(if (not (Print 12 3 #at 20 120 #edit @local11 18)) ; "Number to dial: (ESC to hang up) (xxx-xxxx) or (xxx-xxx-xxxx)"
						(self changeState: 999)
						(break)
					else
						(if
							(and
								(== (StrLen @local11) 1)
								(== 35 (StrAt @local11 0))
								(Parse @local171 myEvent)
							)
							(myEvent type: 128)
							(phoneNumber handleEvent: myEvent)
							(break)
						)
						(if
							(and
								(< (StrLen @local11) 7)
								(!= (StrCmp @local11 {0}) 0)
								(!= (StrCmp @local11 {411}) 0)
							)
							(Print 12 4) ; "Please use the proper format: (xxx-xxx-xxxx) or (xxx-xxxx)"
							(continue)
						)
						(cond
							((== (StrAt @local11 0) 49)
								(Print 12 5) ; "You do not need to put a '1' first."
							)
							((Parse @local11 myEvent)
								(StrCpy @local171 @local11)
								(myEvent type: 128)
								(phoneNumber handleEvent: myEvent)
								(break)
							)
						)
					)
				)
			)
			(999
				(HandsOn)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said '/411,0')
				(gCurRoom setScript: Information)
			)
			((Said '/5558723')
				(localproc_5 12 6)
				(localproc_5 12 7)
				(localproc_3)
				(gCurRoom setScript: phoneNumber)
			)
			((Said '/5552222')
				(localproc_2)
			)
			((Said '/4075556844')
				(localproc_2)
			)
			((Said '/5551699')
				(localproc_2)
			)
			((Said '/5552052')
				(localproc_2)
			)
			((Said '/5554495')
				(localproc_5 12 8)
				(localproc_3)
				(gCurRoom setScript: phoneNumber)
			)
			((Said '/5554169')
				(cond
					((== gPrevRoomNum 32)
						(localproc_2 40)
					)
					((!= global100 6)
						(localproc_2 95)
					)
					(else
						(gCurRoom setScript: talkingToMarie)
					)
				)
			)
			((Said '/5553344')
				(if (== gPrevRoomNum 61)
					(localproc_2 40)
				else
					(localproc_2)
				)
			)
			((Said '/4075553323')
				(if (or (< global100 8) (IsFlag 95))
					(localproc_2)
				else
					(gCurRoom setScript: talkingToColby)
				)
			)
			((Said '/5555432')
				(if (== gPrevRoomNum 4)
					(localproc_2 40)
				else
					(gCurRoom setScript: lyttonPD)
				)
			)
			((Said '/4075552677')
				(if (<= global100 8)
					(localproc_2 40)
				else
					(gCurRoom setScript: steeltonPD)
				)
			)
			((Said '/5550001')
				(localproc_2 40)
			)
			((Said '/2096834463')
				(if (== (Random 1 2) 1)
					(localproc_5 12 9)
					(localproc_5 12 10)
					(localproc_3)
					(gCurRoom setScript: phoneNumber)
				else
					(localproc_5 12 11)
					(localproc_5 12 12)
					(localproc_5 12 13)
					(localproc_3)
					(gCurRoom setScript: phoneNumber)
				)
			)
			((Said '/2096836858')
				(if (< (Random 1 10) 4)
					(gCurRoom setScript: alLowe)
				else
					(gCurRoom setScript: sierra)
				)
			)
			((Said '/unknownnumber')
				(if (< (Random 1 10) 3)
					(gCurRoom setScript: sicko)
				else
					(localproc_2)
				)
			)
			(else
				(Print 12 14) ; "Please enter a number."
				(self changeState: 0)
			)
		)
	)
)

(instance Information of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 6 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 6 cel: 0 posn: 74 65 setCycle: End)
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local11 0)
				(= local181 0)
				(localproc_5 12 15)
			)
			(2
				(= local11 0)
				(localproc_5 12 16)
			)
			(3
				(localproc_5 12 17)
				(= state 1)
				(= cycles 2)
			)
			(4
				(localproc_5 12 18)
				(= state 0)
				(= cycles 2)
			)
			(999
				(localproc_3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(switch state
			(1
				(cond
					((Said '/steelton')
						(= local181 1)
						(self changeState: 2)
					)
					((Said '/lytton')
						(= local181 2)
						(self changeState: 2)
					)
					((Said '/coarsegold')
						(= local181 3)
						(self changeState: 2)
					)
					((Said '/houston')
						(= local181 4)
						(self changeState: 2)
					)
					(else
						(event claimed: 1)
						(localproc_5 12 19)
						(localproc_5 12 20)
						(self changeState: 999)
					)
				)
			)
			(2
				(switch local181
					(2
						(cond
							((Said '/police')
								(localproc_5 12 21)
							)
							((Said '/cheeks<cheeks')
								(localproc_5 12 22)
							)
							((Said '/cheeks,(cheeks<!*)')
								(self changeState: 3)
								(return)
							)
							((Said '/cove<cotton')
								(localproc_5 12 23)
							)
							((Said '/arnie,cafe')
								(localproc_5 12 24)
							)
							((Said '/jail')
								(localproc_5 12 25)
							)
							((Said '/airport')
								(localproc_5 12 26)
							)
							((Said '/inn')
								(localproc_5 12 27)
							)
							(else
								(event claimed: 1)
								(self changeState: 4)
								(return)
							)
						)
						(if (== state 2)
							(self changeState: 999)
						)
					)
					(1
						(cond
							((Said '/police,lpd,(department<police)')
								(localproc_5 12 28)
							)
							((Said '/park<burt')
								(localproc_5 12 29)
							)
							(else
								(event claimed: 1)
								(self changeState: 4)
								(return)
							)
						)
						(if (== state 2)
							(self changeState: 999)
						)
					)
					(3
						(if (Said '/sierra,(online<sierra),(line<on<sierra)')
							(localproc_5 12 30)
							(localproc_5 12 31)
							(self changeState: 999)
						else
							(event claimed: 1)
							(self changeState: 4)
						)
					)
					(else
						(event claimed: 1)
						(self changeState: 4)
					)
				)
			)
		)
	)
)

(instance talkingToColby of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 setLoop: 2 cel: 0 posn: 63 80 stopUpd:)
		(local3 setLoop: 2 cel: 0 posn: 69 63 setCycle: End)
		(RedrawCast)
		(= local6 0)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_5 12 32)
			)
			(2
				(localproc_5 12 33)
			)
			(999
				(localproc_3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			(
				(or
					(Said '/hello')
					(and (== state 1) (or (Said 'talk') (Said '//bonds')))
				)
				(switch state
					(1
						(localproc_4 12 34)
						(self changeState: 2)
					)
					(else
						(localproc_4 12 32)
					)
				)
			)
			(
				(or
					(Said 'talk/bains,escape,death,(list<hit)')
					(Said 'talk//bains,escape,death,(list<hit)')
					(Said 'warn/bains,colby')
				)
				(switch state
					(1
						(localproc_5 12 35)
					)
					(else
						(localproc_4 12 36)
						(localproc_5 12 37)
						(localproc_5 12 38)
						(SetScore 4 95)
						(self changeState: 999)
					)
				)
			)
			(else
				(if (Said 'talk')
					(switch (Random 0 1)
						(0
							(localproc_4 12 39)
						)
						(1
							(localproc_4 12 40)
						)
					)
				else
					(event claimed: 1)
				)
				(switch state
					(1
						(localproc_5 12 41)
						(++ local6)
					)
					(2
						(switch (Random 0 4)
							(0
								(localproc_5 12 42)
							)
							(1
								(localproc_5 12 43)
							)
							(else
								(localproc_5 12 44)
							)
						)
						(if (> (++ local6) 2)
							(localproc_5 12 45)
							(self changeState: 999)
						)
					)
				)
			)
		)
	)
)

(instance talkingToMarie of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 1 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 1 cel: 0 posn: 71 63 setCycle: End)
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_5 12 32)
			)
			(2
				(localproc_5 12 46)
				(localproc_5 12 47)
			)
			(999
				(localproc_5 12 48)
				(localproc_3)
				(= global100 7)
				(SetScore 3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((or (Said '/hello,bonds,cheeks') (Said '//bonds'))
				(localproc_4 12 49)
				(self changeState: 2)
			)
			((or (Said 'talk') (Said 'yes'))
				(if (== state 2)
					(self changeState: 999)
				else
					(localproc_4 12 49)
					(self changeState: 2)
				)
			)
			((Said 'no')
				(if (== state 2)
					(localproc_5 12 50)
					(localproc_3)
					(client setScript: phoneNumber)
				else
					(localproc_5 12 51)
				)
			)
			((== state 1)
				(event claimed: 1)
				(self changeState: 1)
			)
			(else
				(event claimed: 1)
				(localproc_5 12 52)
				(localproc_5 12 53)
			)
		)
	)
)

(instance steeltonPD of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 4 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 4 cel: 0 posn: 65 64 setCycle: End)
		(= local7 0)
		(= local5 0)
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_5 12 54)
			)
			(999
				(localproc_3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			(
				(or
					(Said '/hello')
					(and (== state 1) (or (Said 'talk') (Said '//bonds')))
				)
				(if (== state 1)
					(localproc_4 12 55)
					(localproc_5 12 56)
					(= local5 1)
					(= state 2)
				else
					(localproc_5 12 57)
				)
			)
			(
				(or
					(Said '(talk,warn)[/bains,colby,death]')
					(Said '(talk,warn)/*[/bains,colby,death]')
				)
				(= local5 0)
				(switch state
					(1
						(localproc_5 12 58)
					)
					(2
						(if (IsFlag 94)
							(localproc_5 12 59)
							(localproc_5 12 60)
							(self changeState: 999)
						else
							(localproc_4 12 61)
							(localproc_4 12 62)
							(localproc_5 12 63)
							(SetScore 4 94)
							(self changeState: 999)
						)
					)
				)
			)
			((Said 'yes')
				(if (and (== state 2) local5)
					(localproc_5 12 64)
				else
					(localproc_5 12 51)
				)
			)
			((Said 'no')
				(if (and (== state 2) local5)
					(localproc_5 12 65)
				else
					(localproc_5 12 51)
				)
			)
			(else
				(event claimed: 1)
				(= local5 0)
				(switch state
					(1
						(localproc_5 12 41)
					)
					(2
						(if local7
							(localproc_4 12 66)
							(localproc_5 12 67)
							(localproc_3)
							(client setScript: phoneNumber)
						else
							(localproc_4 12 68)
							(localproc_5 12 69)
							(++ local7)
						)
					)
				)
			)
		)
	)
)

(instance lyttonPD of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 5 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 5 cel: 0 posn: 77 67 setCycle: End)
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_5 12 70)
			)
			(3
				(localproc_5 12 71)
				(local2 posn: 30 1000)
				(local3 posn: 60 1000)
				(RedrawCast)
				(= seconds 20)
			)
			(4
				(Print 12 72) ; "You have a feeling that somehow you were forgotten."
				(-- state)
				(= seconds 15)
			)
			(999
				(localproc_3)
				(= seconds 0)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((or (== state 3) (== state 4))
				(event claimed: 1)
				(Print 12 73) ; "No one is listening to you."
			)
			((Said '/burglary,narcotics,homicide')
				(if (== state 1)
					(switch (Random 0 1)
						(0
							(localproc_5 12 74)
						)
						(else
							(localproc_5 12 75)
						)
					)
					(localproc_5 12 76)
					(= local5 1)
				else
					(localproc_5 12 57)
				)
			)
			((Said 'yes,yes')
				(if (== local5 1)
					(= local5 0)
					(self changeState: 3)
				else
					(localproc_5 12 51)
				)
			)
			((Said 'no')
				(if (== local5 1)
					(= local5 0)
					(localproc_5 12 77)
					(self changeState: 999)
				else
					(localproc_5 12 51)
				)
			)
			((== state 1)
				(event claimed: 1)
				(localproc_5 12 78)
				(self changeState: 1)
			)
		)
	)
)

(instance sierra of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 8 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 8 cel: 0 posn: 73 60 setCycle: End)
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_5 12 79)
				(localproc_5 12 80)
			)
			(2
				(localproc_5 12 81)
				(localproc_5 12 82)
				(self changeState: 999)
			)
			(999
				(localproc_3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(if (and (== state 1) (Said '/hello'))
			(self changeState: 1)
		else
			(event claimed: 1)
			(self changeState: (++ state))
		)
	)
)

(instance alLowe of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 7 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 7 cel: 0 posn: 74 69 setCycle: End)
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(localproc_5 12 83)
			)
			(2
				(localproc_5 12 84)
				(localproc_5 12 85)
				(localproc_5 12 86)
				(localproc_5 12 87)
				(localproc_5 12 88)
			)
			(3
				(localproc_5 12 89)
				(localproc_5 12 90)
				(localproc_5 12 91)
				(localproc_5 12 92)
				(localproc_5 12 93)
				(self changeState: 999)
			)
			(999
				(localproc_3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(if (Said '/dumb,dumb')
			(localproc_5 12 94)
			(localproc_5 12 95)
			(localproc_5 12 96)
			(localproc_3)
			(client setScript: phoneNumber)
		else
			(event claimed: 1)
			(self changeState: (++ state))
		)
	)
)

(instance sicko of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(local2 loop: 9 cel: 0 posn: 63 80 stopUpd:)
		(local3 loop: 9 cel: 0 posn: 71 58 setCycle: End)
		(= local8 (Random 0 2))
		(RedrawCast)
		(self changeState: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(switch local8
					(0
						(localproc_5 12 97)
						(localproc_5 12 97)
					)
					(1
						(localproc_5 12 98)
					)
					(2
						(localproc_5 12 99)
					)
				)
			)
			(2
				(switch local8
					(0
						(= cycles 1)
						(= state 0)
					)
					(1
						(localproc_5 12 100)
						(self changeState: 999)
					)
					(2
						(localproc_5 12 101)
						(self changeState: 999)
					)
				)
			)
			(999
				(localproc_3)
				(client setScript: phoneNumber)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evKEYBOARD)
			(localproc_6 event)
			(return)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((Said 'is<who')
				(localproc_5 12 102)
			)
			((Said 'fuck')
				(localproc_5 12 103)
			)
			(else
				(event claimed: 1)
				(self changeState: (++ state))
			)
		)
	)
)

(instance doTalk of Script
	(properties)

	(method (changeState newState &tmp [temp0 4] temp4 temp5 temp6)
		(switch (= state newState)
			(0
				(if (local3 inRect: 0 0 320 200)
					(local3 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (and (> (StrLen @local11) 15) (local3 inRect: 0 0 320 200))
					(local3 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(= temp4 120)
				(TextSize @[temp0 0] @local11 gSmallFont)
				(if (<= [temp0 2] 10)
					(+= temp4 (- 86 (/ [temp0 3] 2)))
					(= temp6 -1)
				else
					(= temp6 180)
				)
				(= temp5 (- 50 (/ (- [temp0 2] 8) 2)))
				(switch local9
					(0
						(Print @local11 #width temp6 #at temp4 temp5 #font gSmallFont)
					)
					(else
						(Print @local11 #width temp6 #at temp4 temp5 #font gSmallFont)
					)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance doEgoTalk of Script
	(properties)

	(method (changeState newState &tmp [temp0 4] temp4 temp5 temp6)
		(switch (= state newState)
			(0
				(local1 setCycle: End self)
			)
			(1
				(if (> (StrLen @local11) 15)
					(local1 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(= temp4 15)
				(= temp6 180)
				(TextSize @[temp0 0] @local11 gSmallFont)
				(if (<= [temp0 2] 10)
					(+= temp4 (- 86 (/ [temp0 3] 2)))
					(= temp6 -1)
				)
				(= temp5 (- 130 (/ (- [temp0 2] 8) 2)))
				(Print @local11 #width temp6 #at temp4 temp5 #font gSmallFont)
				(client setScript: 0)
			)
		)
	)
)

