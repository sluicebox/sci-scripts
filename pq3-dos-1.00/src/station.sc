;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 891)
(include sci.sh)
(use Main)
(use keyPadBut)
(use Interface)
(use rmnScript)
(use RandCycle)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	station 0
	briefMess 1
	phoneScript 2
)

(local
	local0
	local1
	[local2 8]
)

(instance station of Rgn
	(properties
		keep 1
	)

	(method (init)
		(ScriptID 131) ; keyPadBut
		(phoneSfx init:)
		(super init:)
		(if (and (== gDay 1) (not script) (not (IsFlag 1)))
			(self setScript: briefMess)
		)
		(if (and (== gDay 1) (not script) (not (IsFlag 54)))
			(self setScript: briefMess)
		)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 12 13 14 15 16 17 18 19 20 21 22 23 24))
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(== gDay 2)
					(not (gCurRoom script:))
					(IsFlag 75)
					(IsFlag 76)
					(IsFlag 77)
					(IsFlag 78)
				)
				(gCurRoom setScript: goToHosScript)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 131)
		(super dispose:)
	)
)

(instance goToHosScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(Print 891 0) ; "Guess it's time to call it a day. Before you close out your shift, you head over to the hospital to see Marie."
				(= global134 0)
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance briefMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 300)
			)
			(1
				(cond
					((not (IsFlag 8))
						(Print 891 1) ; "Sonny Bonds, please report to the briefing room."
						(= seconds 300)
					)
					((not (IsFlag 54))
						(if
							(or
								(gCurRoom script:)
								(& (gEgo onControl: 0) $2000)
							)
							(= state 0)
							(= cycles 1)
						else
							(SetFlag 54)
							(if (== gCurRoomNum 24)
								(HandsOff)
								(global113 setScript: escAspen)
							else
								(Print 891 2) ; "Sonny Bonds, please call dispatch at once."
							)
							(= seconds 300)
						)
					)
					((not (IsFlag 207))
						(SetFlag 207)
						(Print 891 2) ; "Sonny Bonds, please call dispatch at once."
						(= seconds 300)
					)
				)
			)
			(2
				(cond
					((not (IsFlag 8))
						(SetFlag 8)
						(Print 891 1) ; "Sonny Bonds, please report to the briefing room."
						(= seconds 300)
					)
					((IsFlag 206)
						(= seconds 1)
					)
					((IsFlag 207)
						(Print 891 2) ; "Sonny Bonds, please call dispatch at once."
						(= seconds 300)
					)
					((IsFlag 55)
						(= seconds 1)
					)
					((IsFlag 54)
						(cond
							(
								(or
									(gCurRoom script:)
									(& (gEgo onControl: 0) $2000)
								)
								(= cycles (= state 1))
							)
							((== gCurRoomNum 24)
								(HandsOff)
								(global113 setScript: escAspen)
							)
							(else
								(Print 891 2) ; "Sonny Bonds, please call dispatch at once."
								(= seconds 300)
							)
						)
					)
				)
			)
			(3
				(cond
					((IsFlag 207)
						(EgoDead 19) ; "Your failure to respond to the mall resulted in a suspension.  An officer who doesn't report to assigned calls puts the public in danger!"
					)
					((IsFlag 54)
						(EgoDead 8) ; "You failure to respond the Aspen Falls call resulted in a suspension. An officer who doesn't report to assigned calls puts the public in danger."
					)
					((IsFlag 8)
						(EgoDead 7) ; "Your failure to report to today's officer briefing resulted in a suspension. When duty calls... listen!"
					)
				)
			)
		)
	)
)

(instance escAspen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global113 setPri: 12 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(1
				(Say global113 891 3) ; "Sure I'll tell him."
				(= seconds 3)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(global113 setCycle: End self)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Say global113 891 4) ; "Hey Sonny, dispatch needs you to drive out to Aspen Falls to respond to a call. All other units are occupied."
				(= seconds 7)
			)
			(4
				(SetFlag 55)
				(SetFlag 6)
				(SetFlag 58)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance phoneScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(User canInput: 1)
				(User canControl: 1)
				(User mapKeyToDir: 0)
				(phoneInset init: self)
				(= local0 0)
				(StrCpy @local2 {})
				(self register: -1)
				(gGame setCursor: 20)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(SetCursor 20 1 33 139)
			)
			(1
				(cond
					((>= local0 7)
						(= local1 1)
						(= cycles 1)
					)
					((== register -1)
						(= state 0)
						(= cycles 1)
					)
					((== register 13)
						(= cycles (= state 3))
					)
					((< register 11)
						(phoneSfx stop:)
						(++ local0)
						(StrCat @local2 (Format @temp1 891 5 register)) ; "%d"
						(self register: -1)
						(= state 0)
						(= cycles 1)
					)
					(else
						(self register: -1)
						(= state 0)
						(= cycles 1)
					)
				)
			)
			(2
				(phoneSfx number: 935 loop: 2 play:)
				(if (not (StrCmp @local2 {5550707}))
					(= state 4)
				)
				(= seconds 3)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 891 6) ; "You have reached a number that is no longer in service."
				(= state 5)
				(= cycles 1)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(self setScript: dispatchScript)
				(= state 5)
				(= cycles 1)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (or (IsFlag 19) (!= gDay 2))
					(Print 891 7 #dispose) ; "No answer."
					(= seconds 2)
				else
					(SetFlag 19)
					(self setScript: reporter self)
				)
			)
			(6
				(phoneSfx stop:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(User mapKeyToDir: 1)
				(phoneInset dispose:)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance reporter of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(phoneInset dispose:)
				(repInset init:)
				(Say repInset 891 8) ; "Lytton Daily News. May I help you."
				(= seconds 4)
			)
			(1
				(= save1 1)
				(repInset dispose:)
				(Print 891 9 #at 10 10 #dispose) ; "You identify yourself, describe Marie's attack, and request help from the paper in locating a witness."
				(= seconds 7)
			)
			(2
				(= save1 1)
				(repInset init:)
				(Say repInset 891 10) ; "Yes Sir, Officer. We'll get that in the very next edition. And... good luck, Sir."
				(= seconds 6)
			)
			(3
				(SetScore 131 5)
				(proc0_17 20)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo put: 38) ; busCard
				(repInset dispose:)
				(self dispose:)
			)
		)
	)
)

(instance dispatchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((IsFlag 33)
						(Print 891 11) ; "We already put it on the air, Bonds"
					)
					((and (IsFlag 32) (== gDay 5))
						(Print 891 12) ; "The voice on the other end says... "Dispatch, can I help you?""
						(Print 891 13) ; "You advise dispatch to broadcast an all points bulletin for the possible suspect vehicle."
						(Print 891 14) ; "You discribe the vehicle as being a gold General Motors sedan with possible white paint transfers."
						(Print 891 15) ; "You also advise that the occupants may be armed and dangerous and to approach with caution."
						(Print 891 16) ; "I've got it all," she says. "I'll put this out on the air immediately!"
						(SetFlag 33)
						(SetScore 162 5)
					)
					((and (IsFlag 54) (not (IsFlag 55)))
						(SetFlag 55)
						(SetFlag 6)
						(SetFlag 58)
						(Print 891 17) ; "Dispatch: "Sonny, we need you to drive out to Aspen Falls to respond to a call. All other units are occupied.""
						(= global112 111)
					)
					((and (IsFlag 207) (not (IsFlag 206)))
						(SetFlag 206)
						(Print 891 18) ; "Respond to an assault at the 300 block of east Rose,... the Oak Tree Mall."
					)
					(else
						(Print 891 19) ; "If you don't have a reason to call, don't."
						(phoneSfx stop:)
					)
				)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance phoneInset of View
	(properties
		x 60
		y 187
		view 235
		priority 15
		signal 16
	)

	(method (init param1)
		(no1 playSound: 0 posn: (- (self x:) 5) (self y:) 58 init: param1)
		(no2 playSound: 0 posn: (+ (self x:) 6) (self y:) 58 init: param1)
		(no3 playSound: 0 posn: (+ (self x:) 17) (self y:) 58 init: param1)
		(no4 playSound: 0 posn: (- (self x:) 5) (self y:) 48 init: param1)
		(no5 playSound: 0 posn: (+ (self x:) 6) (self y:) 48 init: param1)
		(no6 playSound: 0 posn: (+ (self x:) 17) (self y:) 48 init: param1)
		(no7 playSound: 0 posn: (- (self x:) 5) (self y:) 38 init: param1)
		(no8 playSound: 0 posn: (+ (self x:) 6) (self y:) 38 init: param1)
		(no9 playSound: 0 posn: (+ (self x:) 17) (self y:) 38 init: param1)
		(no10 playSound: 0 posn: (+ (self x:) 6) (self y:) 28 init: param1)
		(no11 playSound: 0 posn: (- (self x:) 5) (self y:) 28 init: param1)
		(no12 playSound: 0 posn: (+ (self x:) 17) (self y:) 28 init: param1)
		(dBut playSound: 0 posn: (+ (self x:) 4) (self y:) 13 init: param1)
		(phone posn: (- (self x:) 31) (+ (self y:) 10) 10 init:)
		(self stopUpd: 1)
		(super init:)
	)

	(method (dispose)
		(no1 dispose:)
		(no2 dispose:)
		(no3 dispose:)
		(no4 dispose:)
		(no5 dispose:)
		(no6 dispose:)
		(no7 dispose:)
		(no8 dispose:)
		(no9 dispose:)
		(no10 dispose:)
		(no11 dispose:)
		(no12 dispose:)
		(dBut dispose:)
		(phone dispose:)
		(hanger dispose:)
		(super dispose:)
	)
)

(instance phone of Prop
	(properties
		view 235
		cel 1
		priority 15
		signal 16
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd: 1)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(InRect nsLeft nsTop nsRight nsBottom event)
						(== (event message:) KEY_RETURN)
					)
					(self dispose:)
					(phoneScript register: -1)
					(phoneScript changeState: 1)
					(event claimed: 1)
					(phoneSfx number: 921 setLoop: -1 play:)
					(gEgo loop: 0 cel: 0 setCycle: CT 6 1)
					(no1 playSound: 1)
					(no2 playSound: 1)
					(no3 playSound: 1)
					(no4 playSound: 1)
					(no5 playSound: 1)
					(no6 playSound: 1)
					(no7 playSound: 1)
					(no8 playSound: 1)
					(no9 playSound: 1)
					(no10 playSound: 1)
					(no11 playSound: 1)
					(no12 playSound: 1)
					(dBut playSound: 1)
					(hanger posn: 29 169 init:)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self dispose:)
					(phoneScript register: -1)
					(phoneScript changeState: 1)
					(phoneSfx number: 921 setLoop: -1 play:)
					(gEgo loop: 0 cel: 0 setCycle: CT 6 1)
					(no1 playSound: 1)
					(no2 playSound: 1)
					(no3 playSound: 1)
					(no4 playSound: 1)
					(no5 playSound: 1)
					(no6 playSound: 1)
					(no7 playSound: 1)
					(no8 playSound: 1)
					(no9 playSound: 1)
					(no10 playSound: 1)
					(no11 playSound: 1)
					(no12 playSound: 1)
					(dBut playSound: 1)
					(hanger posn: 29 169 init:)
					(event claimed: 1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(hanger posn: 29 169 init:)
				(self dispose:)
				(phoneScript register: -1)
				(phoneScript changeState: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hanger of Prop
	(properties
		view 235
		cel 2
		priority 14
		signal 16
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd: 1)
		(super init:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(InRect nsLeft nsTop nsRight nsBottom event)
						(== (event message:) KEY_RETURN)
					)
					(self dispose:)
					(phoneScript changeState: 6)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self dispose:)
					(phoneScript changeState: 6)
					(event claimed: 1)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(self dispose:)
				(phoneScript changeState: 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance no1 of keyPadBut
	(properties
		view 235
		loop 1
		number 1
		keyEquiv 49
		soundNum 922
	)
)

(instance no2 of keyPadBut
	(properties
		view 235
		loop 2
		number 2
		keyEquiv 50
		soundNum 923
	)
)

(instance no3 of keyPadBut
	(properties
		view 235
		loop 3
		number 3
		keyEquiv 51
		soundNum 924
	)
)

(instance no4 of keyPadBut
	(properties
		view 235
		loop 4
		number 4
		keyEquiv 52
		soundNum 925
	)
)

(instance no5 of keyPadBut
	(properties
		view 235
		loop 5
		number 5
		keyEquiv 53
		soundNum 926
	)
)

(instance no6 of keyPadBut
	(properties
		view 235
		loop 6
		number 6
		keyEquiv 54
		soundNum 927
	)
)

(instance no7 of keyPadBut
	(properties
		view 235
		loop 7
		number 7
		keyEquiv 55
		soundNum 928
	)
)

(instance no8 of keyPadBut
	(properties
		view 235
		loop 8
		number 8
		keyEquiv 56
		soundNum 929
	)
)

(instance no9 of keyPadBut
	(properties
		view 235
		loop 9
		number 9
		keyEquiv 57
		soundNum 930
	)
)

(instance no10 of keyPadBut
	(properties
		view 235
		loop 10
		keyEquiv 48
		soundNum 931
	)
)

(instance no11 of keyPadBut
	(properties
		view 235
		loop 11
		number 11
		soundNum 932
	)
)

(instance no12 of keyPadBut
	(properties
		view 235
		loop 12
		number 12
		soundNum 933
	)
)

(instance dBut of keyPadBut
	(properties
		view 235
		loop 13
		number 13
		keyEquiv 100
		soundNum 933
	)
)

(instance repInset of Prop
	(properties
		x 264
		y 127
		view 239
		priority 15
		signal 16400
	)

	(method (init)
		(self stopUpd:)
		(repMouth posn: (self x:) (self y:) setCycle: Fwd init:)
		(super init:)
	)

	(method (dispose)
		(repMouth dispose:)
		(super dispose:)
	)
)

(instance repMouth of Prop
	(properties
		view 239
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyInset of Prop ; UNUSED
	(properties
		x 64
		y 177
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(sonnyMouth
			posn: (+ (self x:) 1) (self y:) 36
			setCycle: RandCycle
			init:
		)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance phoneSfx of Sound
	(properties)
)

