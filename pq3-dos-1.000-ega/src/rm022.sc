;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm022 0
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

(instance rm022 of PQRoom
	(properties
		picture 22
	)

	(method (init)
		(super init:)
		(door init:)
		(clipBoard init:)
		(gAddToPics add: door doit:)
		(if (== gDay 1)
			(cop2 setCycle: Fwd init:)
		)
		(if (not (IsFlag 1))
			(if (IsFlag 8)
				(OIC init:)
				(OICHead init:)
				(lChair init: addToPic:)
			else
				(= local5 1)
				(OIC
					view: 175
					x: 123
					y: 146
					loop: 0
					cel: 0
					setScript: catCalls
					init:
				)
			)
			(cop1 init:)
			(pat init:)
			(SetFlag 217)
			((ScriptID 891 1) dispose:) ; briefMess
		else
			(lChair init: addToPic:)
			(rChair init: addToPic:)
			(pChair init: addToPic:)
		)
		(gEgo
			view: (if (> gDay 1) 4 else 0)
			setStep: 3 2
			x: 249
			y: 99
			init:
		)
		(if (and (IsFlag 217) (IsFlag 1))
			(pat setScript: patExit init:)
		)
		(rm22picture init:)
		(chalkboard init:)
		(podium init:)
		(tables init:)
		(messageBoard init:)
		(briefingRoom init:)
		(self
			setRegions: 891 ; station
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 176 84 155 90 99 97 92 103 82 104 80 101 73 99 16 113 107 189 160 189 118 165 232 124 319 167 319 142 238 107 257 98 287 98 286 92 258 94 222 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 108 100 143 94 155 103 122 112
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 112 158 78 127 187 102 224 121
					yourself:
				)
			posn: 227 113
			setScript: (ScriptID 896 1) ; sWI
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0002)
				(if (not (IsFlag 1))
					(self setScript: OICScript)
				else
					(self posn: 239 103 setScript: (ScriptID 896 2) 0 19) ; sWO
				)
			)
			((and (IsFlag 8) (not (IsFlag 1)))
				(SetFlag 1)
				(= global105 13)
				(= global106 40)
				((ScriptID 891 1) dispose:) ; briefMess
				(self setScript: OICScript)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance catCalls of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local6 3)
					(Print 22 0) ; "Your fellow officers have been a little on edge since the corner donut shop closed. You take their ribbing in stride knowing that it comes with the territory when your the new Sarge on the block."
				)
				(HandsOn)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 45)
			)
			(1
				(= save1 1)
				(if (not (gCurRoom script:))
					(HandsOff)
					(switch local6
						(0
							(Say OIC 22 1) ; "Come on Sarge! Get with the briefing."
							(= seconds 5)
							(= state -1)
						)
						(1
							(Say cop1 22 2) ; "The Lytton public needs us, Sergeant! Give us the crap of the day so we can get out of here."
							(= seconds 8)
							(= state -1)
						)
						(2
							(Say cop2 22 3) ; "You'd think a new Sergeant would know what to do."
							(= seconds 6)
							(= state -1)
						)
						(else
							(Say cop1 22 4) ; "Obviously the Sergeant needs someone to take him by the hand!"
							(= seconds 8)
						)
					)
					(++ local6)
				else
					(= state 0)
					(= seconds 5)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOff)
				(gCurRoom setScript: OICScript)
				(self dispose:)
			)
		)
	)
)

(instance OICScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 180 90 self)
			)
			(1
				(if local5
					(moveChairSound setVol: 4 play:)
					(OIC cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if local5
					(lChair init:)
					(OIC
						ignoreActors: 0
						view: 180
						x: 135
						y: 144
						setCycle: SyncWalk
						ignoreActors: 0
						setMotion: MoveTo 88 156 self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if local5
					(lChair init:)
					(OIC setMotion: PolyPath 120 96 self)
				else
					(= cycles 1)
				)
			)
			(4
				(if local5
					(OIC loop: 2)
				)
				(= cycles 1)
			)
			(5
				(Face gEgo pat self)
			)
			(6
				(Print 22 5) ; "Since you're obviously not up to it, the "Officer in Charge" conducts the briefing."
				(= cycles 2)
			)
			(7
				(= save1 1)
				(OICInset init:)
				(Say OICInset 22 6) ; "Good afternoon, Officers!"
				(= seconds 3)
			)
			(8
				(= save1 1)
				(Say OICInset 22 7) ; "Ahem! Since Sergeant Bonds here has obviously forgotten about filling in for Officer Jaco while he's on vacation,... I will go ahead with the briefing."
				(= seconds 12)
			)
			(9
				(= save1 1)
				(Say OICInset 22 8) ; "Anyway, you all have today's duty sheets..."
				(= seconds 6)
			)
			(10
				(Print 22 9) ; "Officer Miller goes over the duty sheets. Then he says..."
				(= cycles 1)
			)
			(11
				(= save1 1)
				(Say OICInset 22 10) ; "That's it. Have a safe shift and think about making right hand approaches on your car stops."
				(= seconds 8)
			)
			(12
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(OICInset dispose:)
				(SetFlag 8)
				(SetFlag 1)
				(= global105 13)
				(= global106 40)
				((ScriptID 891 1) dispose:) ; briefMess
				(cop1 setPri: -1 setScript: (copExit new:))
				(OICHead dispose:)
				(OIC
					view: 180
					setCycle: SyncWalk
					setMotion: PolyPath 269 96 self
				)
			)
			(13
				(OIC dispose:)
				(pat setScript: patExit)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance brief2Script of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(OIC setScript: 0)
				(gEgo setMotion: PolyPath 110 110 self)
			)
			(1
				(clipBoard hide: forceUpd:)
				(pickUpSnd play:)
				(= cycles 3)
			)
			(2
				(gEgo setMotion: PolyPath 120 96 self)
			)
			(3
				(gEgo loop: 4)
				(= cycles 3)
			)
			(4
				(Print 22 11) ; "You begin the briefing..."
				(= cycles 1)
			)
			(5
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 22 12) ; "Good afternoon, people!"
				(= seconds 4)
			)
			(6
				(= save1 1)
				(Say sonnyInset 22 13) ; "I will be filling in for Sergeant Jaco while he's on vacation."
				(= seconds 6)
			)
			(7
				(= save1 1)
				(sonnyInset dispose:)
				(Print 22 14 #dispose #at 20 20) ; "You advise the afternoon shift of the procedural information and announcements listed on the clipboard and close by saying..."
				(= seconds 7)
			)
			(8
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 22 15) ; "Have a safe shift and think about making right hand approaches on your car stops."
				(= seconds 5)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(gEgo setMotion: PolyPath 110 110 self)
			)
			(10
				(clipBoard show: forceUpd:)
				(SetFlag 8)
				(SetFlag 1)
				(= global105 13)
				(= global106 40)
				((ScriptID 891 1) dispose:) ; briefMess
				(pat setScript: patExit)
				(cop1 setPri: -1 setScript: (copExit new:))
				(OIC setScript: (copExit new:))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance copExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 3 1 self)
			)
			(1
				(moveChairSound setVol: 6 play:)
				(client setCycle: CT 5 1 self)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(if (== client cop1)
					(rChair init: addToPic:)
					(client
						view: 177
						setCycle: Walk
						setMotion: PolyPath 269 96 self
					)
				else
					(client
						view: 180
						setCycle: SyncWalk
						x: 135
						y: 144
						setMotion: PolyPath 269 96 self
					)
					(lChair init: addToPic:)
				)
			)
			(4
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance patExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (not (gEgo has: 18)) (IsFlag 9)) ; patMemo
					(= cycles 1)
				else
					(= seconds 15)
				)
			)
			(1
				(if (not (gCurRoom script:))
					(HandsOff)
					(moveChairSound setVol: 4 play:)
					(client cel: 0 setCycle: End self)
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(2
				(pChair init:)
				(client view: 21 setCycle: Walk setMotion: PolyPath 269 96 self)
			)
			(3
				(ClearFlag 217)
				(HandsOn)
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance patScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 142 109 self)
			)
			(1
				(Face gEgo pat)
				(cond
					((gEgo has: 18) ; patMemo
						(if local4
							(= save1 1)
							(patInset init:)
							(Say patInset 22 16) ; "OK! OK! Your office after the briefing. I heard ya! Sheesh!"
							(= seconds 6)
							(+= state 3)
						else
							(= save1 1)
							(sonnyInset init:)
							(Say sonnyInset 22 17) ; "Morales, I need to have a word with you in my office after this afternoon's briefing."
							(= seconds 6)
						)
					)
					(local3
						(Print 22 18) ; "She REALLY doesn't want to talk to you."
						(= cycles 1)
						(+= state 3)
					)
					(else
						(= save1 1)
						(sonnyInset init:)
						(Say sonnyInset 22 19) ; "Afternoon, Morales."
						(= seconds 4)
						(+= state 1)
					)
				)
			)
			(2
				(sonnyInset dispose:)
				(if (not (IsFlag 1))
					(= save1 1)
					(patInset init:)
					(Say patInset 22 20) ; "Ok,..so what did I do this time? Wait!... don't tell me... another complaint from some moron who thinks he was the victim of police brutality."
					(= seconds 8)
				else
					(= save1 1)
					(patInset init:)
					(Say patInset 22 21) ; "Sure, Sarge. I'd love to come hear some idiot's complaint. It'd make my day."
					(= seconds 8)
				)
				(SetFlag 9)
				(SetScore 93 1)
				(++ local4)
				(+= state 2)
			)
			(3
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 22 22) ; "What is this, a talk show? Just give the damn briefing."
				(= seconds 5)
				(++ local3)
			)
			(4
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(Print 22 23 #dispose #at 10 10) ; "You stutter for a moment then mutter something about just being friendly."
				(= seconds 5)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(patInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance c2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local0
					(0
						(Print 22 24) ; "Officer Joe Banks responds after being interrupted from his report writing..."
						(Say cop2 22 25) ; "Gee Sarge, I'd really like to finish this report."
						(= seconds 5)
					)
					(1
						(Print 22 26) ; "Not looking up, Officer Banks says..."
						(Say cop2 22 27) ; "Please don't break my concentration!"
						(= seconds 5)
					)
					(else
						(Print 22 28) ; "Officer Banks ignores you and continues writing."
						(= cycles 1)
					)
				)
				(++ local0)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance c1Script of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (= local1 register)
					(0
						(Print 22 29) ; "Referring to the academy, Carl says..."
					)
					(1
						(Print 22 29) ; "Referring to the academy, Carl says..."
					)
					(2
						(Print 22 30) ; "Drawing attention to you, Officer Law says..."
					)
					(else
						(Print 22 30) ; "Drawing attention to you, Officer Law says..."
					)
				)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(switch register
					(0
						(Say cop1 22 31) ; "Welcome back from the Palace of Pain!"
					)
					(1
						(Say cop1 22 32) ; "No doubt the Academy hasn't changed any since the crap keeps rolling down hill!"
					)
					(2
						(Say cop1 22 33) ; "Looky here guys and gals, another star is born! We have a new Sergeant."
					)
					(else
						(Say cop1 22 34) ; "I bet the metamorphosis from good guy to Sergeant was a real experience. Ha! Ha!"
					)
				)
				(++ local1)
				(= seconds 7)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance oicScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(switch local2
					(0
						(Say OIC 22 35) ; "Can we get on with the briefing Sarge? I've got a date with a coffee shop!"
					)
					(1
						(Say OIC 22 36) ; "Hey Sarge! The glare coming off your new chevrons is blinding us. The department's gonna hafta' issue us sun glasses. HA!"
					)
					(else
						(Say OIC 22 37) ; "I got a card from Sergeant Jaco. He says he's having a great time in the Bahamas - the scum."
					)
				)
				(++ local2)
				(= seconds 7)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance OICHead of Prop
	(properties
		x 125
		y 68
		description {OIC Head}
		view 179
		loop 2
		priority 6
		signal 16401
	)
)

(instance OIC of Actor
	(properties
		x 123
		y 98
		description {Kevin Miller}
		lookStr {That's Officer Kevin Miller. He's one of the old-school cops.}
		view 179
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 22 38) ; "Hands off, Bonds!"
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: oicScript)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 22 39) ; "Sonny Bonds wouldn't do that in a million years."
					)
					(19 ; wallet
						(Print 22 40) ; "They KNOW who you are, Bonds."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cop1 of Actor
	(properties
		x 198
		y 131
		description {Carl Law}
		lookStr {That's Officer Carl Law. Carl's a real cut-up.}
		view 176
		priority 8
		signal 16401
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(3 ; Do
				(Print 22 38) ; "Hands off, Bonds!"
			)
			(5 ; Talk
				(HandsOff)
				(= temp0 (Random 0 3))
				(gCurRoom setScript: c1Script 0 temp0)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 22 39) ; "Sonny Bonds wouldn't do that in a million years."
					)
					(19 ; wallet
						(Print 22 40) ; "They KNOW who you are, Bonds."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cop2 of Prop
	(properties
		x 219
		y 170
		description {Joseph Banks}
		lookStr {That's Officer Joseph Banks. Young, smart, and takes his job very seriously.}
		view 178
		priority 13
		signal 16401
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(3 ; Do
				(Print 22 38) ; "Hands off, Bonds!"
			)
			(5 ; Talk
				(HandsOff)
				(= temp0 (Random 0 2))
				(gCurRoom setScript: c2Script 0 temp0)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 22 39) ; "Sonny Bonds wouldn't do that in a million years."
					)
					(19 ; wallet
						(Print 22 40) ; "They KNOW who you are, Bonds."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clipBoard of Prop
	(properties
		x 121
		y 98
		description {clipboard}
		lookStr {The clipboard contains the notes for today's briefing.}
		view 174
		priority 6
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (not (IsFlag 1))
					(HandsOff)
					(gCurRoom setScript: brief2Script)
					(SetScore 94 1)
				else
					(Print 22 41) ; "This afternoon's briefing is already concluded."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pat of Actor
	(properties
		x 154
		y 143
		description {Pat Morales}
		lookStr {The female officer is Pat Morales. You hear she's a tough cookie.}
		view 182
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 22 42) ; "Not a chance."
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: patScript)
			)
			(4 ; Inventory
				(switch invItem
					(18 ; patMemo
						(HandsOff)
						(gCurRoom setScript: patScript)
					)
					(1 ; gun
						(Print 22 43) ; "Surely you can think of better ways to handle a woman - even an arrogant one!"
					)
					(19 ; wallet
						(Print 22 40) ; "They KNOW who you are, Bonds."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pChair of View
	(properties
		x 170
		y 134
		description {chair}
		lookStr {The chairs are for the officers attending the briefing.}
		view 174
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 44) ; "You don't need to sit down."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lChair of View
	(properties
		x 130
		y 144
		description {chair}
		lookStr {The chairs are for the officers attending the briefing.}
		view 174
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 44) ; "You don't need to sit down."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rChair of View
	(properties
		x 203
		y 124
		description {chair}
		lookStr {The chairs are for the officers attending the briefing.}
		view 174
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 44) ; "You don't need to sit down."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance patInset of Prop
	(properties
		x 253
		y 125
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pEyes posn: (self x:) (self y:) setScript: patEyesBlink init:)
		(patMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(patMouth dispose:)
		(pEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance patMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 4
	)
)

(instance pEyes of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 2
		priority 15
		signal 16401
	)
)

(instance patEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(pEyes cel: 1)
				(= cycles 4)
			)
			(2
				(pEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sonnyInset of Prop
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sonnyMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
		(sonnyEyes setScript: 0 dispose:)
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

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance door of PicView
	(properties
		x 238
		y 97
		description {Sonny}
		lookStr {The door leads back to the hall.}
		view 174
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 45) ; "Just walk out."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance OICInset of View
	(properties
		x 253
		y 125
		view 183
		priority 15
		signal 16401
	)

	(method (init)
		(oicMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(oicMouth dispose:)
	)
)

(instance oicMouth of Prop
	(properties
		view 183
		loop 1
		priority 15
		signal 16401
		cycleSpeed 4
	)
)

(instance rm22picture of Feature
	(properties
		x 161
		y 57
		description {picture}
		onMeCheck 8
		lookStr {Soothing, isn't it?}
	)
)

(instance chalkboard of Feature
	(properties
		x 116
		y 63
		description {chalkboard}
		onMeCheck 4
		lookStr {The chalkboard has nothing important on it at this time.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 46) ; "Sorry, no chalk."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance podium of Feature
	(properties
		x 126
		y 90
		description {podium}
		onMeCheck 16
		lookStr {The podium is used for giving briefings.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 47) ; "You can't give the briefing that way."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance messageBoard of Feature
	(properties
		x 202
		y 60
		onMeCheck 16384
		lookStr {The message board is where the daily briefing notes are posted after the briefing.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 22 48) ; "Those postings need to stay up for public consumption."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tables of Feature
	(properties
		x 167
		y 127
		description {tables}
		onMeCheck 32
		lookStr {The tables are for the officers attending the briefing.}
	)
)

(instance briefingRoom of Feature
	(properties
		lookStr {This is the briefing room. The junior officers meet here for news, reminders, and the occasional reprimands.}
	)
)

(instance moveChairSound of Sound
	(properties
		number 947
	)
)

(instance pickUpSnd of Sound
	(properties
		number 232
	)
)

