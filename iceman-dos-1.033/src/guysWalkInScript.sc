;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n821)
(use Approach)
(use Avoid)
(use Motion)
(use User)
(use System)

(public
	guysWalkInScript 0
)

(local
	local0
	local1
	[local2 3]
	local5
)

(instance guysWalkInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 232 posn: 310 120 setCycle: Walk loop: 1 init:)
				((ScriptID 30 2) ; captain
					view: 133
					posn: 300 122
					init:
					setCycle: Walk
					loop: 1
					setAvoider: Avoid
				)
				((ScriptID 30 3) setCycle: End self) ; entryDoor
			)
			(1
				((ScriptID 30 2) setMotion: MoveTo 280 122 self) ; captain
			)
			(2
				((ScriptID 30 2) setMotion: MoveTo 270 122 self) ; captain
			)
			(3
				((ScriptID 30 3) setCycle: Beg) ; entryDoor
				(gEgo setMotion: MoveTo 270 122)
				((ScriptID 30 2) setMotion: MoveTo 222 115 self) ; captain
				(Print 200 0) ; "As the Captain walks across the room, he says, "Just a second, John, while I get the briefcase out of the safe.""
			)
			(4
				((ScriptID 30 4) illegalBits: 0 init:) ; case
				((ScriptID 30 5) setCycle: End self) ; safeDoor
			)
			(5
				((ScriptID 30 5) stopUpd:) ; safeDoor
				((ScriptID 30 2) setMotion: MoveTo 198 115 self) ; captain
			)
			(6
				((ScriptID 30 2) loop: 3) ; captain
				(gEgo setMotion: MoveTo 213 130 self)
			)
			(7
				((ScriptID 30 4) hide:) ; case
				(gEgo setMotion: MoveTo 213 152 self)
				((ScriptID 30 2) view: 134 setLoop: 0 setMotion: MoveTo 213 130) ; captain
			)
			(8
				(gEgo heading: 90)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				((ScriptID 30 2) setMotion: MoveTo 213 147 self) ; captain
			)
			(9
				((ScriptID 30 2) view: 133 loop: 0) ; captain
				(= cycles 2)
			)
			(10
				((ScriptID 30 4) ; case
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
						(Print 200 1 #edit @local2 12) ; "The Captain speaks to you and says, "Ok John, tell me your half of the combination." (xxx)"
						(cond
							((not (StrCmp @local2 {134}))
								(client setScript: openCaseScript)
							)
							((not (StrCmp @local2 {}))
								(self init:)
							)
							(else
								(++ register)
								(self init:)
							)
						)
					)
					(1
						(Print 200 2 #edit @local2 12) ; "The Captain attempts to open the briefcase and says, "That's the wrong number, I can't get it open.  One more time, John." (xxx)"
						(cond
							((not (StrCmp @local2 {134}))
								(client setScript: openCaseScript)
							)
							((not (StrCmp @local2 {}))
								(self init:)
							)
							(else
								(++ register)
								(self init:)
							)
						)
					)
					(2
						(Print 200 3 #edit @local2 12) ; "The Captain again attempts to open the briefcase.  "Quit playing games with me, John," he says with growing agitation, "I need that number!" (xxx)"
						(cond
							((not (StrCmp @local2 {134}))
								(client setScript: openCaseScript)
							)
							((not (StrCmp @local2 {}))
								(self init:)
							)
							(else
								(++ register)
								(self init:)
							)
						)
					)
					(3
						(Print 200 4) ; "The Captain says to you, "I'm sorry, John, but I have explicit orders not to begin the mission until we have gone over the orders contained within the briefcase.""
						(Print 200 5) ; "The Captain continues, "We have no other choice but to return to Pearl!""
						(EgoDead 7 0 0 200 6) ; "Your lack of attentiveness during the Washington briefing has aborted this mission!"
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
				((ScriptID 30 4) setCycle: End self) ; case
				(gGame changeScore: 1)
			)
			(1
				((ScriptID 30 6) setPri: 14 init: stopUpd:) ; caseView
				((ScriptID 30 7) setPri: 13 init: stopUpd:) ; bkGrnd
				((ScriptID 30 8) setPri: 15 init:) ; manila
				(User canInput: 1)
			)
			(2
				(HandsOff)
				(Print 200 7) ; "Well!" Captain Jonathan Hawkins says, "Looks like the fat's in the fire!"
				(Print 200 8) ; "John boy," he continues, "Let's shove off and get back to work!"
				(Print 200 9) ; "Give me those orders," he says, taking them from your hand, "I'll see to it that they're destroyed."
				((ScriptID 30 4) setCycle: Beg self) ; case
				(gEgo put: 0) ; Envelope
			)
			(3
				((ScriptID 30 7) dispose:) ; bkGrnd
				((ScriptID 30 6) dispose:) ; caseView
				((ScriptID 30 4) setMotion: MoveTo 227 131 self) ; case
			)
			(4
				((ScriptID 30 4) hide:) ; case
				((ScriptID 30 2) ; captain
					view: 134
					setLoop: 1
					setMotion: MoveTo 213 130 self
				)
			)
			(5
				((ScriptID 30 2) setMotion: MoveTo 198 115 self) ; captain
			)
			(6
				((ScriptID 30 4) ; case
					view: 430
					loop: 0
					cel: 3
					setPri: -1
					posn: 195 87
					show:
					stopUpd:
				)
				((ScriptID 30 2) ; captain
					view: 133
					loop: 3
					setLoop: -1
					setMotion: MoveTo 222 115 self
				)
			)
			(7
				((ScriptID 30 5) setCycle: Beg self) ; safeDoor
			)
			(8
				((ScriptID 30 5) stopUpd:) ; safeDoor
				(Print 200 10) ; "Just before leaving the room, the Captain says..."
				(Print 200 11) ; "Westland, make sure you figure out the coordinates of our proposed route and enter them into the computerized charts table."
				((ScriptID 30 2) ; captain
					setAvoider: Avoid
					setMotion: Approach (ScriptID 30 3) 12 self ; entryDoor
				)
			)
			(9
				((ScriptID 30 3) setCycle: End self) ; entryDoor
			)
			(10
				((ScriptID 30 2) ; captain
					illegalBits: 0
					setMotion:
						MoveTo
						(+ ((ScriptID 30 3) x:) 10) ; entryDoor
						((ScriptID 30 2) y:) ; captain
						self
				)
			)
			(11
				((ScriptID 30 2) ; captain
					setMotion:
						MoveTo
						(+ ((ScriptID 30 2) x:) 10) ; captain
						((ScriptID 30 2) y:) ; captain
				)
				((ScriptID 30 3) setCycle: Beg self) ; entryDoor
			)
			(12
				(HandsOn)
				(gEgo observeControl: 2)
				(subMarine cue: 1)
				((ScriptID 30 2) setScript: (ScriptID 30 9)) ; captain, waitForEgoScript
				(self dispose:)
				(DisposeScript 200)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'ask//combination') (Said 'get/combination'))
				(switch local5
					(0
						(Print 200 12) ; "The Captain says, "Oh yes, John, I'm glad you reminded me. The combination to the safe is 23448803. And the first half of the briefcase combination is 762.""
						(gGame changeScore: 5)
						(++ local5)
					)
					(1
						(Print 200 13) ; "Didn't I already tell you? Well, anyway, the combination to the safe is 23448803. And the first half of the briefcase combination is 762."
						(++ local5)
					)
					(2
						(Print 200 14) ; "John, I'm beginning to have doubts about your mental state! I'm not going to tell you again! The combination to the safe is 23448803. And the first half of the briefcase combination is 762."
						(++ local5)
					)
					(else
						(Print 200 15) ; "The captain justs shakes his head."
					)
				)
			)
			((not ((ScriptID 30 5) cel:))) ; safeDoor
			(
				(or
					(Said 'open/top')
					(Said 'adjust,insert,use/id,card[<id][/slot,hole]')
				)
				(if ((ScriptID 30 4) cel:) ; case
					(Print 200 16) ; "As you attempt to open the compartment, the Captain says, "John, you can fool around with that extra compartment some other time. We need to get this sub moving!""
				else
					(Print 200 17) ; "The case is currently closed."
				)
			)
			((Said 'get/envelope[<manila]')
				(if (gEgo has: 0) ; Envelope
					(proc0_35) ; "You already took that."
				else
					(Print 200 18) ; "You remove the envelope from the case. Opening it, you see that the contents are a chart and set of orders."
					(gEgo get: 0) ; Envelope
					((ScriptID 30 4) loop: 3) ; case
					((ScriptID 30 8) dispose:) ; manila
				)
			)
			((Said 'look/envelope[<manila]')
				(if (not (gEgo has: 0)) ; Envelope
					(proc0_38) ; "You don't have that."
				else
					(Print 200 19) ; "A letter-sized manila envelope. Inside is a chart and set of orders."
				)
			)
			((Said 'open/envelope[<manila]')
				(if (not (gEgo has: 0)) ; Envelope
					(proc0_38) ; "You don't have that."
				else
					(Print 200 20) ; "It's already open."
				)
			)
			((Said 'look,read[<at]/chart,map')
				(cond
					((not (gEgo has: 0)) ; Envelope
						(proc0_38) ; "You don't have that."
						(return)
					)
					(local0
						(Print 200 21 #icon 430 5 1) ; "Again you look the chart over and see that your destination is the Mediterranean."
					)
					(else
						(Print 200 22 #icon 430 5 1) ; "You carefully look the chart over and see that your destination is the Mediterranean."
						(= local0 1)
					)
				)
				(if local1
					(self cue:)
				)
			)
			((Said 'get/order')
				(if (gEgo has: 0) ; Envelope
					(Print 200 23) ; "You already have them. Just read them."
				else
					(proc0_38) ; "You don't have that."
				)
			)
			((Said 'look,read[<at]/order')
				(cond
					(local1
						(Print 200 24) ; "You already read them."
					)
					((gEgo has: 0) ; Envelope
						(Print 200 25) ; "You read over the orders which contain the following:"
						(Print 200 26) ; "Commit the following orders to memory before destroying them:"
						(Print 200 27) ; "The expediency of this mission is of utmost importance to the survival of the Ambassador."
						(Print 200 28) ; "Use extreme caution navigating the Bering Sea. The USSR is threatening blockade of the Straits due to claimed violations of United States military operating inside her territorial waters."
						(Print 200 29) ; "Washington has denied these accusations and has issued a counter communique warning the Soviets that appropriate action would be taken if any blockade is encountered."
						(Print 200 30) ; "Arrive Mediterranean at 12 degrees longitude and 36 degrees latitude no later than 0700 January 29th."
						(Print 200 31) ; "Rendezvous with female CIA agent at nearby oasis at 1000 hours January 29th."
						(Print 200 32) ; "Come to periscope depth at 0930 hours this date for further coded messages."
						(Print 200 33) ; "Your destination is the Mediterranean Sea and the east coast of Tunisia. The route you must follow will include the following areas:"
						(Print 200 34) ; "Bering Sea, Bering Straits, Arctic Ocean, Greenland Sea, Denmark Strait between Greenland and Iceland."
						(Print 200 35) ; "Proceed south through the North Atlantic, east through the Straits of Gibraltar into the Mediterranean."
						(Print 200 36) ; "From time to time you will receive additional orders by radio."
						(Print 200 37) ; "Good luck and Godspeed!"
						(if local0
							(self cue:)
						else
							(= seconds 6)
						)
						(= local1 1)
					)
					(else
						(proc0_38) ; "You don't have that."
					)
				)
			)
			((Said 'close/briefcase')
				(if ((ScriptID 30 4) cel:) ; case
					(proc0_39) ; "You don't need to do that."
				else
					(Print 200 17) ; "The case is currently closed."
				)
			)
		)
	)
)

