;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n821)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	captsQuartersRm 0
)

(local
	[local0 5]
	local5
	local6 = 100
	local7
	[local8 3]
	local11
	local12
	local13
	local14
	local15
	local16
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
		(safeDoor init:)
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
				(subMarine roomFlags: (| (subMarine roomFlags:) $0001))
				(self setScript: guysWalkInScript)
				(gAddToPics add: chairPV doit:)
			)
			((not (& (subMarine roomFlags:) $0002))
				(gEgo
					view: 232
					posn: 290 119
					setCycle: Walk
					loop: 1
					init:
					setMotion: MoveTo 280 119
				)
				(gAddToPics add: chairPV doit:)
				(HandsOn)
			)
			(else
				(Load rsVIEW 130)
				(= local7 3)
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
					illegalBits: 0
					ignoreActors: 1
					posn: 52 150
					init:
					stopUpd:
				)
				(HandsOn)
			)
		)
		(= local12 (Random 0 1))
		(gAddToPics add: blackHawkPV shipPV plantPV eachElementDo: #init doit:)
		(proc824_0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(if (< (gEgo x:) (bathDoor x:))
					(event claimed: 0)
				else
					(Print 30 0) ; "Looking around you see the captains quarters."
				)
			)
			((Said 'talk')
				(Print 30 1) ; "You don't have time for idle chatter."
			)
		)
	)
)

(instance guysWalkInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 232 posn: 310 120 setCycle: Walk loop: 1 init:)
				(captain
					view: 133
					posn: 300 122
					init:
					setCycle: Walk
					loop: 1
					setAvoider: Avoid
				)
				(entryDoor setCycle: End self)
			)
			(1
				(captain setMotion: MoveTo 280 122 self)
			)
			(2
				(captain setMotion: MoveTo 270 122 self)
			)
			(3
				(entryDoor setCycle: Beg)
				(gEgo setMotion: MoveTo 270 122)
				(captain setMotion: MoveTo 222 115 self)
				(Print 30 2) ; "As the Captain walks across the room he says, "Just a second John while I get the briefcase out of the safe.""
			)
			(4
				(case illegalBits: 0 init:)
				(safeDoor setCycle: End self)
			)
			(5
				(captain setMotion: MoveTo 198 115 self)
			)
			(6
				(captain loop: 3)
				(gEgo setMotion: MoveTo 213 130 self)
			)
			(7
				(case hide:)
				(gEgo setMotion: MoveTo 213 152 self)
				(captain view: 134 setLoop: 0 setMotion: MoveTo 213 130)
			)
			(8
				(gEgo heading: 90)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(captain setMotion: MoveTo 213 147 self)
			)
			(9
				(captain view: 133 loop: 0)
				(= cycles 2)
			)
			(10
				(case
					view: 134
					setLoop: 2
					setCel: 0
					posn: 227 131
					setPri: 11
					show:
					setMotion: MoveTo 237 131 self
				)
			)
			(11
				(client setScript: tryToOpenCaseScript)
			)
		)
	)
)

(instance tryToOpenCaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(Print 30 3 #edit @local8 12) ; "The Captain speaks to you and says, "Ok John, tell me your half of the combination." (xxx)"
						(cond
							((not (StrCmp @local8 {134}))
								(client setScript: openCaseScript)
							)
							((not (StrCmp @local8 {}))
								(self init:)
							)
							(else
								(++ register)
								(self init:)
							)
						)
					)
					(1
						(Print 30 4 #edit @local8 12) ; "The Captain attempts to open the briefcase and says, "That's the wrong number, I can't get it open.  One more time, John." (xxx)"
						(cond
							((not (StrCmp @local8 {134}))
								(client setScript: openCaseScript)
							)
							((not (StrCmp @local8 {}))
								(self init:)
							)
							(else
								(++ register)
								(self init:)
							)
						)
					)
					(2
						(Print 30 5 #edit @local8 12) ; "The Captain again attempts to open the briefcase.  "Quit playing games with me John!" he says with growing agitation, "I need that number!" (xxx)"
						(cond
							((not (StrCmp @local8 {134}))
								(client setScript: openCaseScript)
							)
							((not (StrCmp @local8 {}))
								(self init:)
							)
							(else
								(++ register)
								(self init:)
							)
						)
					)
					(3
						(Print 30 6) ; "The Captain says to you, "I'm sorry John, but I have explicit orders not to begin the mission until we have gone over the orders contained within the briefcase.""
						(Print 30 7) ; "The Captain continues, "We have no other choice but to return to Pearl!""
						(EgoDead 7 0 0 30 8) ; "Your lack of attentiveness during the Washington briefing has aborted this mission!"
					)
				)
			)
		)
	)
)

(instance openCaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(case setCycle: End self)
				(gGame changeScore: 1)
			)
			(1
				(bkGrnd setPri: 13 init:)
				(caseView setPri: 14 init:)
				(manila setPri: 15 init:)
				(User canInput: 1)
			)
			(2
				(Print 30 9) ; "Well!" Captain Jonathan Hawkins says, "Looks like the fat's in the fire!"
				(Print 30 10) ; "John boy" he continues, "Let's hit the bricks and get back to work!"
				(Print 30 11) ; "Give me those orders." he says, taking them from your hand, "I'll see to it that they're destroyed."
				(case setCycle: Beg self)
				(= local7 3)
			)
			(3
				(bkGrnd dispose:)
				(caseView dispose:)
				(case setMotion: MoveTo 227 131 self)
			)
			(4
				(case hide:)
				(captain view: 134 setLoop: 1 setMotion: MoveTo 213 130 self)
			)
			(5
				(captain setMotion: MoveTo 198 115 self)
			)
			(6
				(case view: 430 loop: 0 cel: 3 setPri: -1 posn: 195 87 show:)
				(captain
					view: 133
					loop: 3
					setLoop: -1
					setMotion: MoveTo 222 115 self
				)
			)
			(7
				(safeDoor setCycle: Beg self)
			)
			(8
				(Print 30 12) ; "Just before leaving the room the Captain says..."
				(Print 30 13) ; "Westland, make sure you figure out the coordinates of our proposed route and enter them into the computerized charts table."
				(captain setAvoider: Avoid setMotion: MoveTo 252 122 self)
			)
			(9
				(entryDoor setCycle: End self)
			)
			(10
				(captain
					illegalBits: 0
					setMotion: MoveTo (+ (entryDoor x:) 10) (captain y:) self
				)
			)
			(11
				(captain setMotion: MoveTo (+ (captain x:) 10) (captain y:))
				(entryDoor setCycle: Beg self)
			)
			(12
				(HandsOn)
				(subMarine cue: 1)
				(captain setScript: waitForEgoScript)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,in]/briefcase')
				(cond
					((not (safeDoor cel:))
						(proc0_40) ; "You don't see that."
					)
					((not (gCast contains: caseView))
						(Print 30 14) ; "A brown leather briefcase."
					)
					(else
						(if (!= local7 0)
							(Print 30 15) ; "The open briefcase is empty."
						else
							(Print 30 16) ; "Looking into the briefcase you see a manila envelope."
						)
						(Print 30 17) ; "You think to yourself, "Something looks odd about the top section of the briefcase.""
						(Print 30 18) ; "Looking closer, you can definitely tell there is a second compartment in the top section of the briefcase."
						(Print 30 19) ; ""If I can just figure out how to get into it," you think."
					)
				)
			)
			((Said 'get/combination')
				(switch local16
					(0
						(Print 30 20) ; "The captain says, "Oh yes, John, I'm glad you reminded me. The combination to the safe is 23448803. And the first half of the briefcase combination is 762.""
						(gGame changeScore: 5)
						(++ local16)
					)
					(1
						(Print 30 21) ; "Didn't I already tell you? Well, anyway, the combination to the safe is 23448803. And the first half of the briefcase combination is 762."
						(++ local16)
					)
					(2
						(Print 30 22) ; "John, I'm beginning to have doubts about your mental state! I'm not going to tell you again! The combination to the safe is 23448803. And the first half of the briefcase combination is 762."
						(++ local16)
					)
					(else
						(Print 30 23) ; "The captain justs shakes his head."
					)
				)
			)
			((not (safeDoor cel:)))
			((or (Said 'open/top') (Said 'insert,use/id,card[<id]'))
				(if (case cel:)
					(Print 30 24) ; "As you attempt to open the compartment, the Captain says, "John, you can fool around with that extra compartment some other time. We need to get this sub moving!""
				else
					(Print 30 25) ; "The case is currently closed."
				)
			)
			((Said 'get/envelope[<manila]')
				(if (> local7 0)
					(proc0_35) ; "You already took that."
				else
					(Print 30 26) ; "You remove the envelope from the case."
					(= local7 1)
					(case loop: 3)
					(manila dispose:)
				)
			)
			((Said 'open/envelope[<manila]')
				(switch local7
					(0
						(proc0_38) ; "You don't have that."
					)
					(1
						(Print 30 27) ; "Opening the envelope, you look in and see the contents to be a chart and set of orders."
						(= local7 2)
					)
					(2
						(Print 30 28) ; "It's already open."
					)
				)
			)
			((Said 'look/envelope[<manila]')
				(switch local7
					(3
						(event claimed: 0)
					)
					(else
						(Print 30 29) ; "A letter-sized manila envelope."
					)
				)
			)
			((Said 'look,read[<at]/chart')
				(if (== local7 2)
					(Print 30 30 #icon 430 5 1) ; "You carefully look the chart over and see that your destination is the Mediterranean."
				else
					(proc0_38) ; "You don't have that."
				)
			)
			((Said 'look,read[<at]/order')
				(if (== local7 2)
					(Print 30 31) ; "You read over the orders which contain the following:"
					(Print 30 32) ; "Commit the following orders to memory before destroying them."
					(Print 30 33) ; "The expediency of this mission is of utmost importance to the survival of the Ambassador."
					(Print 30 34) ; "Use extreme caution navigating the Bering Sea. The USSR is threatening blockade of the Straits due to claimed violations of United States military operating inside her territorial waters."
					(Print 30 35) ; "Washington has denied these accusations and has issued a counter communique warning the Soviets that appropriate action would be taken if any blockade is encountered."
					(Print 30 36) ; "Arrive Mediterranean at 11 degrees longitude and 35 degrees latitude no later than 0700 January 29th"
					(Print 30 37) ; "Rendezvous with female CIA agent at nearby oasis at 1000 hours January 29th."
					(Print 30 38) ; "Come to periscope depth at 0930 hours this date for further coded messages."
					(Print 30 39) ; "Your destination is the Mediterranean Sea and the east coast of Tunisia. The route you must follow will include the following areas."
					(Print 30 40) ; "Bering Sea, Bering Straits, Arctic Ocean, Greenland Sea, Denmark Strait between Greenland and Iceland."
					(Print 30 41) ; "South through the North Atlantic. East through the Straits of Gibraltar into the Mediterranean."
					(Print 30 42) ; "From time to time you will receive additional orders by radio."
					(Print 30 43) ; "Good luck and Godspeed!"
					(self cue:)
				else
					(proc0_38) ; "You don't have that."
				)
			)
			((Said 'close/briefcase')
				(if (case cel:)
					(proc0_39) ; "You don't need to do that."
				else
					(Print 30 25) ; "The case is currently closed."
				)
			)
		)
	)
)

(instance waitForEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(HandsOff)
				(entryDoor setCycle: End self)
			)
			(2
				(captain setMotion: MoveTo 252 122 self)
			)
			(3
				(Print 30 44) ; "Well son!" the Captain says, "If you're confused over what I just said, just follow me and I'll lead you back to the control room!"
				(captain setMotion: MoveTo (+ (entryDoor x:) 10) 122 self)
			)
			(4
				(HandsOn)
				(entryDoor setCycle: Beg)
				(captain setMotion: MoveTo (+ (captain x:) 10) (captain y:))
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
				(Print 30 45) ; "Well, if you're not willing to do the job you were hired to do," says the Captain with disgust, "I guess we'll have to find someone else!"
				(captain setMotion: MoveTo (+ (entryDoor x:) 10) 122 self)
			)
			(8
				(entryDoor setCycle: Beg self)
			)
			(9
				(EgoDead 7 0 0 30 46) ; "What a wimp, next time do what needs to be done."
			)
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
				(bkGrnd setPri: 13 init:)
				(caseView setPri: 14 init:)
				(= start state)
			)
			(9
				(slot setPri: 15 init: cycleSpeed: 2 setCycle: End self)
				(SetScore subMarine 406 16 1)
			)
			(10
				(if (== ((gInventory at: 2) cel:) 1) ; ID_Card
					(= cycles 30)
				else
					(case setScript: ficheScript)
					(self dispose:)
				)
			)
			(11
				(slot setCycle: Beg self)
			)
			(12
				(Print 30 47) ; "The machine has rejected your ID card."
				(self init:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'open/briefcase')
				(if (not (case cel:))
					(Print 30 48 #edit @local8 12) ; "Input combination (ESC to abort) (xxxxxx)"
					(cond
						((not (StrCmp @local8 {762134}))
							(self cue:)
						)
						((not (StrCmp @local8 {}))
							(return)
						)
						(else
							(Print 30 49) ; "Nothing happens."
						)
					)
				else
					(Print 30 50) ; "You already did that."
				)
			)
			((Said 'close/briefcase')
				(if (case cel:)
					(if (== ((gInventory at: 2) cel:) 1) ; ID_Card
						(Print 30 51) ; "You remove the ID card from the slot."
						(slot dispose:)
					)
					(case setScript: closeCaseScript)
				else
					(Print 30 25) ; "The case is currently closed."
				)
			)
			((or (Said 'get/briefcase') (Said 'place/briefcase/safe'))
				(case setScript: closeCaseScript)
			)
			((Said 'examine,look[<at,in]/briefcase')
				(if (case cel:)
					(Print 30 52) ; "Having already removed the Manila envelope from the briefcase you take a closer look."
					(Print 30 17) ; "You think to yourself, "Something looks odd about the top section of the briefcase.""
					(Print 30 18) ; "Looking closer, you can definitely tell there is a second compartment in the top section of the briefcase."
					(Print 30 53) ; ""If I can just figure out how to get into it." you think."
				else
					(Print 30 54) ; "It's a brown leather briefcase."
				)
			)
			((Said 'look[<at]/top')
				(if (case cel:)
					(Print 30 55) ; "You find a small slot located in the top of the case."
				else
					(Print 30 25) ; "The case is currently closed."
				)
			)
			((Said 'open/top')
				(if (case cel:)
					(Print 30 56) ; "The top compartment of the briefcase requires a card with specially coded security clearance to open it."
				else
					(Print 30 25) ; "The case is currently closed."
				)
			)
			((Said 'insert,use/id,card[<id]')
				(cond
					((not (case cel:))
						(event claimed: 0)
					)
					((gEgo has: 2) ; ID_Card
						(Print 30 57) ; "Taking the ID card from your pocket, you insert it into the slot."
						(gEgo put: 2) ; ID_Card
						(self cue:)
					)
					(else
						(Print 30 58) ; "You don't have your ID card."
					)
				)
			)
			((Said 'get,get/card[<id]')
				(if (gEgo has: 2) ; ID_Card
					(Print 30 59) ; "You already have it."
				else
					(slot dispose:)
					(Print 30 60) ; "You remove the card from the slot."
					(gEgo get: 2) ; ID_Card
					(self init:)
				)
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
				(Print 30 61) ; "In the top compartment of the briefcase, you see a device called a "Microfiche" which is used to magnify microfilm so it is readable."
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
				(Print 30 62) ; "You pocket your ID card after it emerges from the microfiche."
				(gEgo get: 2) ; ID_Card
				(case setScript: closeCaseScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'examine,look[<at,in]/briefcase')
				(Print 30 54) ; "It's a brown leather briefcase."
			)
			((Said 'use/microfiche')
				(if (gEgo has: 1) ; Microfilm
					(Print 30 63) ; "You need to "insert microfilm" into the microfiche."
				else
					(Print 30 64) ; "You need microfilm in order to utilize the microfiche."
				)
			)
			((Said 'insert/film')
				(if (gEgo has: 1) ; Microfilm
					(Print 30 65) ; "You insert the microfilm into the microfiche."
					(gEgo put: 1) ; Microfilm
					(codeView setPri: 15 init:)
					(Animate (gCast elements:) 0)
					(Print 30 66) ; "CIA   by service decoding alternate codes   A = -2   N = 3  AF = -1   M = 5"
				else
					(Print 30 67) ; "You don't have any microfilm."
				)
			)
			((or (Said 'get,get/card[<id]') (Said 'close/briefcase'))
				(self cue:)
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
				(case view: 430 loop: 0 cel: 3 setPri: -1 posn: 195 87 show:)
			)
			(5
				(safeDoor setCycle: Beg self)
			)
			(6
				(HandsOn)
				(safeDoor setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance captain of Act
	(properties
		view 133
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
			((Said '[/doc]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 68) ; "Looks like the doctorly type."
					)
					((Said 'talk')
						(if (not local5)
							(= local5 1)
							(Print 30 69) ; "The "Doc" looks at you and says, "I'm sure the Captain will be requiring this medication for a few days to come.""
							(Print 30 70) ; "Well," he continues, "It looks like the Blackhawk and crew is in your hands now."
						else
							(Print 30 71) ; "Please excuse me" he says, "I must attend to the Captain."
						)
					)
				)
			)
			((Said 'talk/captain')
				(Print 30 72) ; "The paramedic speaks up and says, "I'm sorry Commander, but the Captain is under medication and sleeping.""
				(Print 30 73) ; "Continuing he says, "The amount of pain he was experiencing from the head injury made it necessary to sedate him.""
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 74) ; "A typical navy chair."
					)
					((Said 'sit')
						(Print 30 75) ; "This is no time for a break."
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look<in')
						(if (not cel)
							(Print 30 76) ; "You can't see into it."
						else
							(Print 30 77) ; "You see the inside of the safe."
						)
					)
					((Said 'look[<at]')
						(Print 30 78) ; "A safe."
					)
					((GoToIfSaid self event 222 115 0 30 79))
					((Said 'open')
						(if (safeDoor cel:)
							(Print 30 50) ; "You already did that."
						else
							(User canControl: 0)
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

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 2) (not (self script:)))
			(if (gEgo mover:)
				(= local13 ((gEgo mover:) x:))
				(= local14 ((gEgo mover:) y:))
				(= local15 ((gEgo mover:) caller:))
			)
			(HandsOff)
			(self setScript: bathDoorScript)
		)
	)

	(method (cue)
		(self stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 80) ; "The bathroom door."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					(
						(and
							(> (gEgo x:) x)
							(GoToIfSaid self event 57 117 'open' 30 79)
						))
					(
						(and
							(< (gEgo x:) x)
							(GoToIfSaid self event 26 117 'open' 30 79)
						))
					((Said 'open')
						(HandsOff)
						(self setScript: bathDoorScript)
					)
				)
			)
			((> (gEgo x:) (self x:)))
			((Said 'look[<at,around][/room]')
				(Print 30 81) ; "You look around the small but adequate bathroom facility."
				(Print 30 82) ; "It is equipped with a small sink, mirror, shower and marine toilet. There is a small light above the toilet."
			)
			((Said 'look/sink')
				(Print 30 83) ; "It's small and made of stainless steel."
			)
			((or (Said 'use/sink') (Said 'wash/hand') (Said 'turn<on/water'))
				(Print 30 84) ; "In an effort to conserve the water supply, you quickly wash your hands then turn off the water."
			)
			((Said 'look/mirror')
				(Print 30 85) ; "You look into the mirror and think, "Yep, I still look the same.""
			)
			((Said 'comb/hair')
				(Print 30 86) ; "Since cleanliness and grooming are part of Navy life, you look into the mirror and comb your hair."
			)
			((Said 'look/shower')
				(Print 30 87) ; "The only thing special about this shower is that it's small."
			)
			((Said '(turn<on),use,get/shower')
				(Print 30 88) ; "In record time you take a hot shower."
			)
			((Said 'look/light')
				(Print 30 89) ; "This is a typical marine toilet that dumps waste into the ships holding tanks."
				(Print 30 90) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 30 91) ; "If you flush the toilet when this light is on, the pressure will cause the contents of the holding tanks to be forcibly expelled through your toilet."
			)
			((Said 'look/toilet')
				(Print 30 89) ; "This is a typical marine toilet that dumps waste into the ships holding tanks."
				(Print 30 90) ; "When the holding tanks are full, they are pressurized to force the waste into the open ocean."
				(Print 30 92) ; "It is highly recommended that the toilet not be flushed when the tanks are pressurized."
			)
			((Said 'flush/toilet')
				(cond
					(local11
						(= local11 0)
						(flushNoise play:)
						(Print 30 93) ; "Your failure to follow explicit instruction has left you a stinking mess."
						(Print 30 94) ; "As you hurriedly clean the enormous amount of human waste off your body, we are busy deducting 3 points from your score."
						(gGame changeScore: -3)
					)
					(local12
						(Print 30 95) ; "The holding tanks are pressurized. Flushing is not recommended."
						(= local12 (Random 0 1))
						(= local11 1)
					)
					(else
						(Print 30 96) ; "You flush the toilet."
						(= local12 (Random 0 1))
					)
				)
			)
			((or (Said 'leak') (Said 'get/leak'))
				(Print 30 97) ; "Step closer Johnny, it's shorter than you think."
			)
			((or (Said 'shit') (Said 'get/shit'))
				(Print 30 98) ; "The human process of waste elimination has made you two pounds lighter."
			)
			((Said 'get/*')
				(Print 30 99) ; "You don't need it."
			)
		)
	)
)

(instance bathDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if (> (gEgo x:) (client x:))
					(= register -1)
				else
					(= register 1)
				)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) (* 35 register))
						(gEgo y:)
						self
				)
			)
			(2
				(client setCycle: Beg client)
				(if (not (gCurRoom script:))
					(HandsOn)
				)
				(if local13
					(gEgo setMotion: MoveTo local13 local14 local15)
				)
				(self dispose:)
			)
		)
	)
)

(instance flushNoise of Sound
	(properties
		number 49
		priority 2
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
		(if (and (== (gEgo onControl: 1) 4) (not (self script:)))
			(HandsOff)
			(self setScript: entryDoorScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 100) ; "The door to this cabin."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
					((< (gEgo x:) (bathDoor x:)))
					((GoToIfSaid self event 267 125 'open' 30 79))
					((Said 'open')
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
				(client setCycle: End self)
			)
			(1
				(if (> (gEgo x:) (client x:))
					(= register -1)
				else
					(= register 1)
				)
				(gEgo
					illegalBits: (if (== register 1) 0 else -32768)
					setMotion:
						MoveTo
						(+ (gEgo x:) (* 35 register))
						(gEgo y:)
						self
				)
			)
			(2
				(gEgo illegalBits: -32768)
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
		(gIceMouseDownHandler add: self)
		(gIceKeyDownHandler add: self)
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
			(Display 30 101 dsCOORD 275 118 dsFONT 30 dsCOLOR 8) ; "88888888"
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
					(Print 30 102) ; "That is not the correct combination."
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
		(gIceMouseDownHandler add: self)
		(gIceKeyDownHandler add: self)
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 103) ; "A storage closet."
					)
					((Said 'open')
						(Print 30 104) ; "There's nothing of interest in there."
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
				(Print 30 105) ; "It's the latest in submarine slumber."
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 106) ; "A plush couch like this is only found in officer's quarters."
					)
					((Said 'sit')
						(Print 30 75) ; "This is no time for a break."
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 107) ; "A table."
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
			((Said '[/bookcase]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 108) ; "The captain's bookshelf."
					)
					((Said 'open')
						(Print 30 109) ; "No, it's private."
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 110) ; "The captain's desk."
					)
					((Said 'open')
						(Print 30 109) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
			((Said '[/drawer]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 111) ; "A desk drawer."
					)
					((Said 'open')
						(Print 30 109) ; "No, it's private."
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
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 30 112) ; "The captain's nightstand."
					)
					((Said 'open')
						(Print 30 109) ; "No, it's private."
					)
					((Said 'close')
						(proc0_31) ; "It is."
					)
				)
			)
		)
	)
)

