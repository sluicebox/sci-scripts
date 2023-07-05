;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use Osc)
(use RandCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm023 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm023 of PQRoom
	(properties
		picture 23
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 4 0 250 251 253)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 156 78 121 90 124 96 144 91 173 114 92 145 74 130 93 100 44 117 123 189 0 189 0 0 319 3 319 171 267 131 236 146 183 112 196 107
					yourself:
				)
		)
		(if (>= gDay 2)
			(= local1 1)
		)
		(if (== gDay 5)
			(= local1 0)
			(= local0 1)
		)
		(if (IsFlag 184)
			(= local2 1)
		)
		(if (or local2 local1)
			(psycho loop: 1 cel: 0 approachVerbs: 5 init:) ; Talk
		)
		(gAddToPics add: chair eachElementDo: #init doit:)
		(clackerSnd init: setVol: 3)
		(clackersS setCycle: Fwd init:)
		(gEgo
			view: (if (> gDay 1) 4 else 0)
			setPri: 12
			setStep: 3 2
			posn: 258 189
			init:
		)
		(self posn: 180 149 setScript: (ScriptID 896 1)) ; sWI
		(pFile approachVerbs: 3 init:) ; Do
		(desk init:)
		(couch init:)
		(rm23Window init:)
		(wasteBasket init:)
		(smallChair init:)
		(fileCabinet init:)
		(bookcase init:)
		(plant init:)
		(aroundRoom init:)
		(interviewSound flags: 1 init: play:)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(self x: 258 y: 189 setScript: (ScriptID 896 2) 0 19) ; sWO
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance getUp of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 23 0) ; "Just as you reach for the file..."
				(psycho cycleSpeed: 8 setCycle: End self approachVerbs: 5 init:) ; Talk
				(psySound init: play:)
			)
			(1
				(= save1 1)
				(pyschInset init:)
				(psycho loop: 1 cel: 0)
				(Say pyschInset 23 1) ; "Hey! That's highly confidential material, Sergeant!"
				(= seconds 7)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(pMouth setCycle: 0 cel: 0)
				(Print 23 2 #at 10 10 #dispose) ; "While you turn bright red, Dr. Aimes asks..."
				(= seconds 4)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(pMouth setCycle: RandCycle)
				(Say pyschInset 23 3) ; "What is it that you WANT, Bonds? I'm a very busy man."
				(= seconds 7)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pyschInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveResults of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Print 23 4 #at 10 10 #dispose) ; "You hand the military record to the doctor."
				(gEgo put: 26) ; miltaryRecord
				(= seconds 4)
			)
			(1
				(= save1 1)
				(pyschInset init:)
				(psyupright stopUpd:)
				(psycho stopUpd:)
				(pMouth show: setCycle: RandCycle)
				(Say pyschInset 23 5) ; "Lovely. I get to peer into the mind of yet another scumbag."
				(= seconds 5)
			)
			(2
				(= save1 1)
				(pMouth setCycle: 0 cel: 0)
				(Print 23 6 #at 10 10 #dispose) ; "The doctor reads Bains' military record."
				(= seconds 5)
			)
			(3
				(= save1 1)
				(Print 23 7 #at 10 10 #dispose) ; "Then goes into his 'analysis' pose."
				(= seconds 3)
				(psycho loop: 2 cel: 0 cycleSpeed: 8 setCycle: End)
			)
			(4
				(psycho stopUpd:)
				(pyschInset init:)
				(psyupright hide:)
				(pMouth hide:)
				(handtwitch setCycle: Fwd init:)
				(mouthTwitch setCycle: Osc 2 self init:)
			)
			(5
				(handtwitch dispose:)
				(mouthTwitch dispose:)
				(psyupright cel: 1 setCycle: End self show:)
				(psycho loop: 1 cel: 0 cycleSpeed: 6 setCycle: End)
			)
			(6
				(= save1 1)
				(psyupright stopUpd:)
				(psycho stopUpd:)
				(pMouth show: setCycle: RandCycle)
				(Say pyschInset 23 8) ; "Rather interesting, actually."
				(= seconds 3)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pMouth hide:)
				(bigTwitch setCycle: Osc 4 self init:)
			)
			(8
				(= save1 1)
				(bigTwitch hide:)
				(pMouth setCycle: RandCycle show:)
				(Print 23 9 #at 10 10 #dispose) ; "He briefs you on the character of Michael Bains."
				(= seconds 4)
			)
			(9
				(= save1 1)
				(Say pyschInset 23 10) ; "This guy's not your average scumbag. He's closer to the slit-his-own-mother's-throat variety."
				(= seconds 7)
				(bHand setCycle: Fwd init:)
			)
			(10
				(bHand dispose:)
				(= cycles 1)
			)
			(11
				(= save1 1)
				(Say pyschInset 23 11) ; "I'd know more if I'd examined him, but based on this, I'd say he's a schizophrenic psychopath."
				(= seconds 7)
			)
			(12
				(= save1 1)
				(Say pyschInset 23 12) ; "This guy's criminally insane, Bonds. I'd be careful how I approached him."
				(= seconds 7)
			)
			(13
				(= local4 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pyschInset dispose:)
				(proc0_17 20)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance askForHelp of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(if local3
					(pyschInset init:)
					(Say pyschInset 23 13) ; "I told you, I can't diagnose thin air."
					(= seconds 8)
					(= state 2)
				else
					(Say gEgo 23 14) ; "Excuse me, Dr. Aimes, I'm tracking a suspected serial killer."
					(= seconds 8)
					(++ local3)
				)
			)
			(1
				(= save1 1)
				(Say gEgo 23 15) ; "Think you can help me out by putting together a psychological profile on him?"
				(= seconds 5)
			)
			(2
				(= save1 1)
				(pyschInset init:)
				(Say pyschInset 23 16) ; "Where's your documentation? I can't diagnose thin air."
				(= seconds 6)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pyschInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance casualTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Print 23 17 #dispose) ; "You try striking up a conversation with Doctor Sidney Aimes."
				(= seconds 5)
			)
			(1
				(= save1 1)
				(pyschInset init:)
				(Say pyschInset 23 18) ; "If you haven't got anything useful to show me, Bonds, please leave. I've no time for chit chat."
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pyschInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance areYouDeaf of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(pyschInset init:)
				(Say pyschInset 23 19) ; "I said, keep your hands off, Sergeant! Are you deaf?"
				(= seconds 5)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pyschInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clackScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(pyschInset init:)
				(Say pyschInset 23 20) ; "Would you mind not playing with my balls, please?"
				(= seconds 5)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pyschInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance psycho of Prop
	(properties
		x 120
		y 107
		approachX 165
		approachY 123
		_approachVerbs 5
		view 250
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 23 21) ; "Dr. Aimes is one of those intellectual types. Not a bad guy, but a little patronizing."
			)
			(5 ; Talk
				(HandsOff)
				(cond
					(local4
						(HandsOn)
						(Print 23 22) ; "Well, Bonds? You've got your information, now go and catch him."
					)
					(local1
						(gCurRoom setScript: askForHelp)
					)
					(else
						(gCurRoom setScript: casualTalk)
					)
				)
			)
			(3 ; Do
				(Print 23 23) ; "Now that IS Freudian."
			)
			(4 ; Inventory
				(switch invItem
					(26 ; miltaryRecord
						(if local4
							(Print 23 24) ; "He's already seen the military record."
						else
							(gCurRoom setScript: giveResults)
							(SetScore 184 5)
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance pyschInset of Prop
	(properties
		x 67
		y 170
		view 251
		priority 15
		signal 16401
	)

	(method (dispose)
		(clackersB dispose:)
		(psyupright dispose:)
		(pMouth dispose:)
		(clackersS setCycle: Fwd startUpd:)
		(super dispose:)
	)

	(method (init)
		(psycho stopUpd:)
		(clackersS cel: 2 setCycle: 0 stopUpd:)
		(psyupright x: (self x:) y: (+ 10 (self y:)) z: 10 init: stopUpd:)
		(pMouth x: (+ (self x:) 6) y: (self y:) z: 63 setCycle: RandCycle init:)
		(clackersB x: (- (self x:) 28) y: (+ (self y:) 14) setCycle: Fwd init:)
		(self stopUpd:)
		(super init:)
	)
)

(instance psyupright of Prop
	(properties
		view 251
		cel 2
		priority 15
		signal 16400
	)
)

(instance eyeblink of Prop ; UNUSED
	(properties
		x 133
		y 44
		view 251
		loop 5
		priority 15
		signal 16400
	)
)

(instance bigtwitch of Prop ; UNUSED
	(properties
		x 133
		y 44
		view 251
		loop 6
		priority 15
		signal 16400
	)
)

(instance pMouth of Prop
	(properties
		view 251
		loop 7
		cel 10
		priority 15
		signal 16400
		cycleSpeed 9
	)
)

(instance bigTwitch of Prop
	(properties
		x 73
		y 187
		z 80
		view 251
		loop 6
		priority 15
		signal 16400
		cycleSpeed 8
	)
)

(instance bHand of Prop
	(properties
		x 67
		y 170
		view 251
		loop 4
		priority 15
		signal 16400
		cycleSpeed 12
	)
)

(instance handtwitch of Prop
	(properties
		x 67
		y 170
		view 251
		loop 1
		priority 15
		signal 16400
		cycleSpeed 10
	)
)

(instance mouthTwitch of Prop
	(properties
		x 76
		y 108
		view 251
		loop 3
		priority 15
		signal 16400
		cycleSpeed 14
	)
)

(instance clackersB of Prop
	(properties
		description {clackers}
		view 251
		loop 8
		cel 5
		priority 15
		signal 16400
		cycleSpeed 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 25) ; "It's one of those mindless excutive toys."
			)
			(3 ; Do
				(Print 23 26) ; "But... you're not a mindless executive."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not local5) (OneOf (self cel:) 0 5))
				(clackerSnd play:)
				(= local5 1)
			)
			((not (OneOf (self cel:) 0 5))
				(= local5 0)
			)
		)
	)
)

(instance clackersS of Prop
	(properties
		x 113
		y 108
		description {clackers}
		view 250
		loop 3
		priority 9
		signal 16400
		cycleSpeed 11
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 27) ; "It's one of those mindless executive toys."
			)
			(3 ; Do
				(if (gCast contains: psycho)
					(HandsOff)
					(gCurRoom setScript: clackScript)
				else
					(Print 23 26) ; "But... you're not a mindless executive."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((and (not local6) (OneOf (self cel:) 0 4))
				(clackerSnd play:)
				(= local6 1)
			)
			((not (OneOf (self cel:) 0 4))
				(= local6 0)
			)
		)
	)
)

(instance chair of PicView
	(properties
		x 109
		y 106
		description {chair}
		view 250
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 28) ; "Dr. Aimes' chair is made of soft Corinthian leather."
			)
			(3 ; Do
				(Print 23 29) ; "If you want to play psychologist, you bought the wrong game."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		description {desk}
		onMeCheck 16384
		approachX 146
		approachY 130
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 30) ; "That's Doctor Aimes' desk. There's a file on the desk."
			)
			(3 ; Do
				(Print 23 31) ; "Doctor Aimes prefers to keep his personal property personal."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pFile of Prop
	(properties
		x 141
		y 99
		description {file}
		approachX 161
		approachY 122
		_approachVerbs 3
		view 253
		priority 7
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 32) ; "It is a personnel file."
			)
			(3 ; Do
				(cond
					(local0
						(SetScore 164 5)
						(proc0_17 20)
						(Print 23 33) ; "No one seems to be around so you pick up the file. You notice that it's a personnel file of Pat Morales."
						(fileSound init: play:)
						(Print 23 34) ; "Afraid of being caught snooping, you read only the doctor's summary."
						(Print 23 35) ; "1. Displays chronic insubordination."
						(Print 23 36) ; "2. Irrational hatred of authority figures."
						(Print 23 37) ; "3. Low self esteem."
						(Print 23 38) ; "4. Borderline sociopath."
						(Print 23 39) ; "SUMMARY."
						(Print 23 40) ; "Evaluation was suggested by Internal Affairs."
						(Print 23 41) ; "Officer Morales was involved in the destruction of evidence on three different occasions."
						(Print 23 42) ; "Internal Affairs concluded the incidents were "coincidental" based on insufficient evidence for disciplinary action."
						(Print 23 43) ; "You return the file to the desk."
						(fileSound play:)
					)
					((gCast contains: psycho)
						(HandsOff)
						(gCurRoom setScript: areYouDeaf)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: getUp)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance couch of Feature
	(properties
		x 223
		y 115
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 44) ; "The proverbial 'confessing couch'."
			)
			(3 ; Do
				(Print 23 45) ; "You prefer a cold beer to Freudian analysis!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rm23Window of Feature
	(properties
		x 226
		y 67
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 46) ; "A window overlooks the parking lot. The blinds are drawn."
			)
			(3 ; Do
				(Print 23 47) ; "The parking lot isn't all that exciting a sight."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wasteBasket of Feature
	(properties
		x 93
		y 127
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 48) ; "It's a theory receptacle."
			)
			(3 ; Do
				(Print 23 49) ; "Nah. You have enough trash at home."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smallChair of Feature
	(properties
		x 205
		y 93
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 50) ; "Dr. Aimes provides a chair for those who feel silly lying down."
			)
			(3 ; Do
				(Print 23 51) ; "You don't feel like sitting down."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fileCabinet of Feature
	(properties
		x 71
		y 75
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 52) ; "The filing cabinets have a lot of dirt on a lot of people."
			)
			(3 ; Do
				(Print 23 53) ; "You can't get in there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookcase of Feature
	(properties
		x 132
		y 45
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 54) ; "Just looking at the titles of Dr. Aimes' books puts you to sleep."
			)
			(3 ; Do
				(Print 23 54) ; "Just looking at the titles of Dr. Aimes' books puts you to sleep."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 68
		y 149
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 55) ; "A bit of green is always nice. This guy probably talks to his plants."
			)
			(5 ; Talk
				(Print 23 56) ; "Don't you have something better to do?"
			)
			(3 ; Do
				(Print 23 57) ; "You get enough vitamin 'B'."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aroundRoom of Feature
	(properties
		x 155
		y 74
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 23 58) ; "This is the office of the department's criminal psychologist, Dr. Sidney Aimes."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance psySound of Sound
	(properties
		number 230
	)
)

(instance interviewSound of Sound
	(properties
		number 231
		loop -1
	)
)

(instance fileSound of Sound
	(properties
		number 232
	)
)

(instance clackerSnd of Sound
	(properties
		number 233
	)
)

