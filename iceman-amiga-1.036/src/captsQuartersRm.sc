;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n316)
(use n821)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	captsQuartersRm 0
	bathDoor 1
	captain 2
	entryDoor 3
	case 4
	safeDoor 5
	caseView 6
	bkGrnd 7
	manila 8
	waitForEgoScript 9
)

(local
	[local0 5]
	local5
	local6 = 100
	[local7 5]
	local12
	local13
)

(instance captsQuartersRm of Rm
	(properties
		picture 30
		east 25
		vanishingX 190
		vanishingY 36
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 30 133 134 230 232 430)
		(HandsOff)
		(gEgo observeControl: 2)
		(safeDoor init: stopUpd:)
		(bathDoor init: ignoreActors: 1)
		(self
			setRegions: 314 ; subMarine
			setFeatures:
				closet
				bunk
				desk
				bookshelf
				nightstand
				table
				couch
				((Clone couch)
					x: 235
					y: 158
					z: 0
					nsLeft: 211
					nsTop: 141
					nsRight: 259
					nsBottom: 176
					yourself:
				)
		)
		(entryDoor init: setCel: 0 ignoreActors: 1 stopUpd:)
		(cond
			((not (& (subMarine roomFlags:) $0001))
				(proc316_0 gCurRoomNum 0)
				(self setScript: (ScriptID 200 0)) ; guysWalkInScript
				(gAddToPics add: chairPV doit:)
			)
			((not (& (subMarine roomFlags:) $0002))
				(gEgo
					view: 232
					posn: 293 119
					setCycle: Walk
					loop: 1
					cel: 7
					init:
					setMotion: MoveTo 280 119
				)
				(gAddToPics add: chairPV doit:)
				(HandsOn)
			)
			(else
				(Load rsVIEW 130)
				(gEgo
					view: 232
					posn: 290 119
					setCycle: Walk
					loop: 1
					init:
					setMotion: MoveTo 280 119
				)
				(doc init:)
				(captain
					view: 130
					loop: 1
					setPri: 15
					illegalBits: 0
					ignoreActors: 1
					posn: 52 150
					init:
					stopUpd:
				)
				(HandsOn)
			)
		)
		(gAddToPics add: blackHawkPV shipPV plantPV eachElementDo: #init doit:)
		(proc824_0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(Print 30 0) ; "Looking around you see the Captain's quarters."
			)
			((Said 'talk')
				(Print 30 1) ; "You don't have time for idle chatter."
			)
		)
	)

	(method (dispose)
		(subMarine roomFlags: (| (subMarine roomFlags:) $0001))
		(gEgo ignoreControl: 2)
		(super dispose:)
	)
)

(instance waitForEgoScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local12 (<= state 1))
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global132 0)
					(= seconds 120)
				else
					(= seconds 30)
				)
			)
			(1
				(HandsOff)
				(entryDoor setCycle: End self)
			)
			(2
				(captain setMotion: capOutMoveTo 252 122 self)
			)
			(3
				(Print 30 2) ; "Well, son!" the Captain says, "If you're confused over what I just said, just follow me and I'll lead you back to the control room!"
				(captain setMotion: MoveTo (+ (entryDoor x:) 10) 122 self)
			)
			(4
				(HandsOn)
				(entryDoor setCycle: Beg)
				(captain
					setMotion: capOutMoveTo (+ (captain x:) 10) (captain y:)
				)
				(= seconds 15)
			)
			(5
				(HandsOff)
				(entryDoor setCycle: End self)
			)
			(6
				(captain setMotion: MoveTo 252 122 self)
			)
			(7
				(Print 30 3) ; "Well, if you're not willing to do the job you were assigned to," says the Captain with disgust, "I guess we'll have to find someone else!"
				(captain setMotion: MoveTo (+ (entryDoor x:) 10) 122 self)
			)
			(8
				(entryDoor setCycle: Beg self)
			)
			(9
				(EgoDead 7 0 0 30 4) ; "What a wimp, next time do what needs to be done."
			)
		)
	)
)

(instance capOutMoveTo of MoveTo
	(properties)

	(method (doit)
		(super doit:)
		(if (client isBlocked:)
			(self moveDone:)
		)
	)
)

(instance openSafeScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(= start 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(case illegalBits: 0 init:)
				(client setCycle: End self)
				(SetScore subMarine 406 4 1)
			)
			(1
				(gEgo setMotion: MoveTo 198 115 self)
			)
			(2
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(3
				(case hide:)
				(gEgo view: 230 setLoop: 0 setMotion: MoveTo 213 130 self)
			)
			(4
				(gEgo setMotion: MoveTo 213 147 self)
			)
			(5
				(gEgo view: 232 heading: 90)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(6
				(case
					view: 134
					setLoop: 3
					setCel: 0
					posn: 227 131
					setPri: 11
					show:
					setMotion: MoveTo 237 131
				)
				(User canInput: 1)
			)
			(7
				(case setCycle: End self)
				(SetScore subMarine 406 8 1)
			)
			(8
				(caseView setPri: 14 init: stopUpd:)
				(bkGrnd setPri: 13 init: stopUpd:)
				(= start state)
			)
			(9
				(HandsOff)
				(slot setPri: 15 init: cycleSpeed: 2 setCycle: End self)
			)
			(10
				(if ((gInventory at: 2) cel:) ; ID_Card
					(= cycles 30)
				else
					(SetScore subMarine 406 16 1)
					(case setScript: ficheScript)
					(self dispose:)
				)
			)
			(11
				(slot setCycle: Beg self)
			)
			(12
				(Print 30 5) ; "The machine has rejected your ID card."
				(User canInput: 1)
				(self init:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'open/briefcase')
				(if (not (case cel:))
					(Print 30 6 #edit @local7 12) ; "Input combination (ESC to abort) (xxxxxx)"
					(cond
						((not (StrCmp @local7 {762134}))
							(self cue:)
						)
						((not (StrCmp @local7 {}))
							(return)
						)
						(else
							(Print 30 7) ; "Nothing happens."
						)
					)
				else
					(Print 30 8) ; "You already did that."
				)
			)
			((Said 'close/briefcase')
				(if (case cel:)
					(if (not (gEgo has: 2)) ; ID_Card
						(Print 30 9) ; "You remove the ID card from the slot."
						(slot dispose:)
					)
					(HandsOff)
					(case setScript: closeCaseScript)
				else
					(Print 30 10) ; "The case is currently closed."
				)
			)
			((or (Said 'get/briefcase') (Said 'adjust/briefcase/safe'))
				(HandsOff)
				(case setScript: closeCaseScript)
			)
			((Said 'look[<at]/top')
				(if (case cel:)
					(Print 30 11) ; "You find a small slot located in the top of the case."
				else
					(Print 30 10) ; "The case is currently closed."
				)
			)
			((Said 'open/top,compartment')
				(if (case cel:)
					(Print 30 12) ; "The top compartment of the briefcase requires a card with specially coded security clearance to open it."
				else
					(Print 30 10) ; "The case is currently closed."
				)
			)
			((Said 'adjust,insert,use/id,card[<id][/slot,hole]')
				(cond
					((not (case cel:))
						(event claimed: 0)
					)
					((gEgo has: 2) ; ID_Card
						(HandsOff)
						(Print 30 13) ; "Taking the ID card from your pocket, you insert it into the slot."
						(gEgo put: 2 gCurRoom) ; ID_Card
						(self cue:)
					)
					(else
						(Print 30 14) ; "You don't have your ID card."
					)
				)
			)
			((Said 'get,get/id,card[<id]')
				(cond
					((gEgo has: 2) ; ID_Card
						(Print 30 15) ; "You already have it."
					)
					((proc316_1 gCurRoomNum 2)
						(slot dispose:)
						(Print 30 16) ; "You remove the card from the slot."
						(gEgo get: 2) ; ID_Card
						(self init:)
					)
					(else
						(proc0_40) ; "You don't see that."
					)
				)
			)
			((Said 'look,read[<at]/order')
				(Print 30 17) ; "They've been destroyed."
			)
		)
	)
)

(instance ficheScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(caseView setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(User canInput: 1)
				(Print 30 18) ; "In the top compartment of the briefcase is a viewer used to magnify microfilm so that it is readable."
			)
			(3
				(HandsOff)
				(codeView dispose:)
				(caseView setCycle: Beg self)
			)
			(4
				(slot setCycle: Beg self)
			)
			(5
				(slot dispose:)
				(Print 30 19) ; "You pocket your ID card after it emerges from the viewer."
				(gEgo get: 2) ; ID_Card
				(if (proc316_1 gCurRoomNum 1)
					(Print 30 20) ; "You also remove the microfilm."
					(gEgo get: 1) ; Microfilm
				)
				(HandsOff)
				(case setScript: closeCaseScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'examine,look[<at,in]/briefcase')
				(Print 30 21) ; "A brown leather briefcase."
			)
			((Said 'use/viewer')
				(if (gEgo has: 1) ; Microfilm
					(Print 30 22) ; "You need to "insert microfilm" into the viewer."
				else
					(Print 30 23) ; "You need microfilm in order to utilize the viewer."
				)
			)
			((Said 'insert/film')
				(cond
					((gEgo has: 1) ; Microfilm
						(Print 30 24) ; "You insert the microfilm into the viewer."
						(gEgo put: 1 gCurRoom) ; Microfilm
						(codeView setPri: 15 init:)
						(Animate (gCast elements:) 0)
						(Print 30 25) ; "CIA decoding offsets to Washington codes   by branch:   A = -2   N = 3  AF = -1   M = 5"
					)
					((proc316_1 gCurRoomNum 1)
						(Print 30 26) ; "The microfilm is already in the viewer."
					)
					(else
						(Print 30 27) ; "You don't have any microfilm."
					)
				)
			)
			((or (Said 'get,get/id,(card[<id])') (Said 'close/briefcase'))
				(self cue:)
			)
			((Said 'look,read[<at]/order')
				(Print 30 17) ; "They've been destroyed."
			)
		)
	)
)

(instance closeCaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (case cel:)
					(case setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(caseView dispose:)
				(bkGrnd dispose:)
				(case setMotion: MoveTo 227 131 self)
			)
			(2
				(case hide:)
				(gEgo view: 230 setLoop: 1 setMotion: MoveTo 213 130 self)
			)
			(3
				(gEgo setMotion: MoveTo 198 115 self)
			)
			(4
				(gEgo
					view: 232
					loop: 3
					setLoop: -1
					setMotion: MoveTo 222 115 self
				)
				(case
					view: 430
					loop: 0
					cel: 3
					setPri: -1
					posn: 195 87
					show:
					stopUpd:
				)
			)
			(5
				(safeDoor setCycle: Beg self)
			)
			(6
				(HandsOn)
				(safeDoor setScript: 0)
				(safeDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance captain of Act
	(properties
		view 133
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((> x (entryDoor x:)))
			((Said '[/captain]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(if (& (subMarine roomFlags:) $0002)
							(Print 30 28) ; "He doesn't look well."
						else
							(Print 30 29) ; "He's very serious about his work."
						)
					)
					((not (& (subMarine roomFlags:) $0002)))
					((Said 'talk')
						(Print 30 30) ; "The paramedic speaks up and says, "I'm sorry Commander, but the Captain is under medication and sleeping.""
						(Print 30 31) ; ""The amount of pain he was experiencing from the head injury made it necessary to sedate him," he explains."
					)
				)
			)
		)
	)
)

(instance doc of Prop
	(properties
		y 147
		x 70
		view 130
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/doc,man]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 32) ; "Looks the medical type."
					)
					((Said 'talk')
						(if (not local5)
							(= local5 1)
							(Print 30 33) ; "The "Doc" looks at you and says, "I'm sure the Captain will require this medication for a few days to come.""
							(Print 30 34) ; "Well," he continues, "It looks like the Blackhawk and crew is in your hands now."
						else
							(Print 30 35) ; "Please excuse me," he says, "I must attend to the Captain."
						)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((!= local6 0)
				(-- local6)
			)
			((not (self cel:))
				(self setCycle: End)
				(= local6 (Random 100 300))
			)
			(else
				(self setCycle: Beg)
				(= local6 (Random 100 300))
			)
		)
	)
)

(instance bkGrnd of View
	(properties
		y 88
		x 246
		view 430
		loop 5
	)
)

(instance manila of View
	(properties
		y 78
		x 246
		view 430
		cel 2
	)
)

(instance caseView of Prop
	(properties
		y 85
		x 246
		view 430
		loop 1
	)

	(method (handleEvent event)
		(case handleEvent: event)
	)
)

(instance slot of Prop
	(properties
		y 50
		x 233
		view 430
		loop 2
	)
)

(instance codeView of View
	(properties
		y 64
		x 246
		view 430
		loop 4
	)
)

(instance blackHawkPV of RPicView
	(properties
		y 71
		x 215
		view 30
	)
)

(instance shipPV of RPicView
	(properties
		y 113
		x 21
		view 30
		cel 1
		priority 9
	)
)

(instance chairPV of RPicView
	(properties
		y 130
		x 84
		view 30
		cel 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/chair]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 36) ; "A typical Navy chair."
					)
					((Said 'sit')
						(Print 30 37) ; "This is no time for a break."
					)
					((Said 'stand')
						(Print 30 38) ; "You are already standing."
					)
				)
			)
		)
	)
)

(instance plantPV of RPicView
	(properties
		y 116
		x 251
		view 30
		cel 3
	)
)

(instance safeDoor of Prop
	(properties
		y 91
		x 199
		view 30
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/safe]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look<in')
						(if (not cel)
							(Print 30 39) ; "You can't see into it."
						else
							(Print 30 40) ; "You see the inside of the safe."
						)
					)
					((Said 'look[<at]')
						(Print 30 41) ; "A safe."
					)
					((GoToIfSaid self event 222 115 'open' 30 42))
					((Said 'open')
						(if (safeDoor cel:)
							(Print 30 8) ; "You already did that."
						else
							(User canInput: 1 canControl: 0)
							(keyPad init:)
						)
					)
				)
			)
			((Said '[/code,keypad]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 43) ; "You see a keypad next to the safe."
					)
					((GoToIfSaid self event 222 115 'enter/code' 30 42))
					((Said 'enter')
						(if (safeDoor cel:)
							(Print 30 8) ; "You already did that."
						else
							(User canInput: 1 canControl: 0)
							(keyPad init:)
						)
					)
				)
			)
		)
	)
)

(instance bathDoor of Prop
	(properties
		y 116
		x 40
		view 30
		loop 2
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 44) ; "The bathroom door."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					(
						(and
							(> (gEgo x:) x)
							(GoToIfSaid self event stupidAvoider 3 'open' 30 42)
						))
					((and (<= (gEgo x:) x) (Said 'open'))
						(self setScript: bathDoorScript)
					)
					((Said 'open')
						(self setScript: bathDoorScript)
					)
				)
			)
			((Said 'exit[/bathroom]')
				(if (<= (gEgo x:) x)
					(self setScript: bathDoorScript)
				else
					(Print 30 45) ; "You're not IN the bathroom."
				)
			)
		)
	)
)

(instance bathDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCycle: End self)
			)
			(1
				(= register (> (gEgo x:) (client x:)))
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (if register 22 else 67) 117 self
				)
			)
			(2
				(client setCycle: Beg client)
				(gEgo observeControl: 2 -32768)
				(if (< (gEgo x:) (client x:))
					(gEgo setScript: (ScriptID 303 0)) ; egosInBathRoom
					(client setScript: 0)
					(HandsOn)
				else
					(gEgo setScript: 0)
					(= cycles 5)
				)
			)
			(3
				(DisposeScript 303)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance entryDoor of Prop
	(properties
		y 115
		x 283
		view 30
		loop 3
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (gEgo onControl: 1) 4)
				(not (self script:))
				(= local12 1)
			)
			(HandsOff)
			(self setScript: entryDoorScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 46) ; "The door to this cabin."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					((< (gEgo x:) (bathDoor x:)))
					((GoToIfSaid self event 267 125 'open' 30 42)
						(= local12 1)
					)
					((Said 'open')
						(= local12 1)
						(HandsOff)
						(self setScript: entryDoorScript)
					)
				)
			)
		)
	)
)

(instance entryDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= cycles 7)
			)
			(1
				(if (> (gEgo x:) (client x:))
					(= register -1)
				else
					(= register 1)
				)
				(gEgo
					illegalBits: (if (== register 1) 0 else -32766)
					setMotion:
						MoveTo
						(+ (gEgo x:) (* 35 register))
						(gEgo y:)
						self
				)
			)
			(2
				(gEgo illegalBits: -32766)
				(client setCycle: Beg self)
			)
			(3
				(if (== register 1)
					(gCurRoom newRoom: 25) ; controlRm
				else
					(if (not (gCurRoom script:))
						(HandsOn)
					)
					(client stopUpd:)
					(= local12 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance case of Act
	(properties
		y 87
		x 195
		view 430
		cel 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said '[/briefcase]>') (Said 'examine,look[<at,in]'))
				(cond
					((== (case script:) ficheScript)
						(Print 30 21) ; "A brown leather briefcase."
					)
					((& (subMarine roomFlags:) $0001)
						(if (case cel:)
							(Print 30 47) ; "Having removed the Manila envelope from the briefcase, you take a closer look."
							(Print 30 48) ; "You think to yourself, "Something looks odd about the top section of the briefcase.""
							(Print 30 49) ; "Looking closer, you can definitely tell there is a second compartment in the top section of the briefcase."
							(Print 30 50) ; ""If I can just figure out how to get into it," you think."
						else
							(Print 30 51) ; "It's a brown leather briefcase."
						)
					)
					((not (safeDoor cel:))
						(proc0_40) ; "You don't see that."
					)
					((not (gCast contains: caseView))
						(Print 30 21) ; "A brown leather briefcase."
					)
					(else
						(if (proc316_1 gCurRoomNum 0)
							(Print 30 52) ; "Looking into the briefcase, you see a manila envelope."
						else
							(Print 30 53) ; "The open briefcase is empty."
						)
						(Print 30 48) ; "You think to yourself, "Something looks odd about the top section of the briefcase.""
						(Print 30 49) ; "Looking closer, you can definitely tell there is a second compartment in the top section of the briefcase."
						(Print 30 50) ; ""If I can just figure out how to get into it," you think."
					)
				)
			)
		)
	)
)

(instance keyPad of View
	(properties
		y 176
		x 291
		view 30
		cel 4
	)

	(method (init)
		(self signal: 257)
		(User mapKeyToDir: 0)
		(oneBut init: @local0)
		(twoBut init: @local0)
		(threeBut init: @local0)
		(fourBut init: @local0)
		(fiveBut init: @local0)
		(sixBut init: @local0)
		(sevenBut init: @local0)
		(eightBut init: @local0)
		(nineBut init: @local0)
		(zeroBut init: @local0)
		(enterBut init:)
		(super init:)
	)

	(method (dispose)
		(User mapKeyToDir: 1)
		(oneBut dispose:)
		(twoBut dispose:)
		(threeBut dispose:)
		(fourBut dispose:)
		(fiveBut dispose:)
		(sixBut dispose:)
		(sevenBut dispose:)
		(eightBut dispose:)
		(nineBut dispose:)
		(zeroBut dispose:)
		(enterBut dispose:)
		(super dispose:)
	)
)

(class KeyPadButton of RFeature
	(properties
		theString 0
		strToCat 0
		keyEquiv 0
		maxLength 0
	)

	(method (init param1)
		(= theString param1)
		(gIceMouseDownHandler addToFront: self)
		(gIceKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(gIceMouseDownHandler delete: self)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if (== (event message:) keyEquiv)
					(self doit:)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self doit:)
					(event claimed: 1)
				)
			)
		)
	)

	(method (doit)
		(if (< (StrLen theString) maxLength)
			(StrCat theString strToCat)
			(Display {88888888} dsCOORD 275 118 dsFONT 30 dsCOLOR 8)
			(Display
				theString
				dsCOORD
				(+ 275 (* 4 (- 8 (StrLen theString))))
				118
				dsFONT
				30
				dsCOLOR
				12
			)
		)
	)
)

(instance oneBut of KeyPadButton
	(properties
		nsTop 128
		nsLeft 275
		nsBottom 136
		nsRight 283
		strToCat {1}
		keyEquiv 49
		maxLength 8
	)
)

(instance twoBut of KeyPadButton
	(properties
		nsTop 128
		nsLeft 286
		nsBottom 136
		nsRight 294
		strToCat {2}
		keyEquiv 50
		maxLength 8
	)
)

(instance threeBut of KeyPadButton
	(properties
		nsTop 128
		nsLeft 299
		nsBottom 136
		nsRight 307
		strToCat {3}
		keyEquiv 51
		maxLength 8
	)
)

(instance fourBut of KeyPadButton
	(properties
		nsTop 140
		nsLeft 275
		nsBottom 148
		nsRight 283
		strToCat {4}
		keyEquiv 52
		maxLength 8
	)
)

(instance fiveBut of KeyPadButton
	(properties
		nsTop 140
		nsLeft 286
		nsBottom 148
		nsRight 294
		strToCat {5}
		keyEquiv 53
		maxLength 8
	)
)

(instance sixBut of KeyPadButton
	(properties
		nsTop 140
		nsLeft 299
		nsBottom 148
		nsRight 307
		strToCat {6}
		keyEquiv 54
		maxLength 8
	)
)

(instance sevenBut of KeyPadButton
	(properties
		nsTop 152
		nsLeft 275
		nsBottom 160
		nsRight 283
		strToCat {7}
		keyEquiv 55
		maxLength 8
	)
)

(instance eightBut of KeyPadButton
	(properties
		nsTop 152
		nsLeft 286
		nsBottom 160
		nsRight 294
		strToCat {8}
		keyEquiv 56
		maxLength 8
	)
)

(instance nineBut of KeyPadButton
	(properties
		nsTop 152
		nsLeft 299
		nsBottom 160
		nsRight 307
		strToCat {9}
		keyEquiv 57
		maxLength 8
	)
)

(instance zeroBut of KeyPadButton
	(properties
		nsTop 164
		nsLeft 299
		nsBottom 172
		nsRight 307
		strToCat {0}
		keyEquiv 48
		maxLength 8
	)
)

(instance enterBut of RFeature
	(properties
		y 285
		x 168
		nsTop 164
		nsLeft 275
		nsBottom 172
		nsRight 295
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(MousedOn self event)
				)
				(if (StrCmp @local0 {23448803})
					(Print 30 54) ; "That is not the correct combination."
					(HandsOn)
					(keyPad dispose:)
					(= local0 0)
				else
					(keyPad dispose:)
					(= local0 0)
					(safeDoor setScript: openSafeScript)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(gIceKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(super dispose:)
		(gIceMouseDownHandler delete: self)
		(gIceKeyDownHandler delete: self)
	)
)

(instance closet of RFeature
	(properties
		y 83
		x 128
		nsTop 54
		nsLeft 105
		nsBottom 113
		nsRight 152
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/closet,cabinet]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 55) ; "A storage closet."
					)
					((Said 'open')
						(Print 30 56) ; "There's nothing of interest in there."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance bunk of RFeature
	(properties
		y 153
		x 61
		nsTop 138
		nsLeft 10
		nsBottom 169
		nsRight 112
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((TurnIfSaid self event 'look[<at]/bunk,bed'))
			((Said 'look[<at][/bunk,bed]')
				(Print 30 57) ; "It's the latest in submarine slumber."
			)
			((Said 'sit')
				(Print 30 37) ; "This is no time for a break."
			)
		)
	)
)

(instance couch of RFeature
	(properties
		y 144
		x 192
		nsTop 113
		nsLeft 174
		nsBottom 176
		nsRight 210
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/couch]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 58) ; "A plush couch like this is only found in officer's quarters."
					)
					((Said 'sit')
						(Print 30 37) ; "This is no time for a break."
					)
				)
			)
		)
	)
)

(instance table of RFeature
	(properties
		y 132
		x 244
		nsTop 124
		nsLeft 222
		nsBottom 140
		nsRight 267
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/table]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 59) ; "A table."
					)
				)
			)
		)
	)
)

(instance bookshelf of RFeature
	(properties
		y 64
		x 79
		nsTop 54
		nsLeft 54
		nsBottom 74
		nsRight 105
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bookcase,shelf]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 60) ; "The captain's bookshelf."
					)
					((Said 'open')
						(Print 30 61) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance desk of RFeature
	(properties
		y 99
		x 79
		nsTop 87
		nsLeft 54
		nsBottom 112
		nsRight 105
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/desk]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 62) ; "The captain's desk."
					)
					((Said 'open')
						(Print 30 61) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
			((Said '[/drawer]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 63) ; "A desk drawer."
					)
					((Said 'open')
						(Print 30 61) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance nightstand of RFeature
	(properties
		y 127
		x 42
		nsTop 117
		nsLeft 27
		nsBottom 137
		nsRight 58
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/dresser]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 30 64) ; "The captain's nightstand."
					)
					((Said 'open')
						(Print 30 61) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

(instance stupidAvoider of Feature
	(properties
		y 117
		x 67
	)
)

