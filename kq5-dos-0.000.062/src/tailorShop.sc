;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Count)
(use RFeature)
(use Follow)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	tailorShop 0
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	[local8 2]
)

(instance tailorShop of Rgn
	(properties)

	(method (init)
		(super init:)
		(gCurRoom setFeatures: shopRoom)
		(gGlobalSound number: 61 loop: -1 play:)
		(= local7 (gEgo illegalBits:))
		(gEgo
			view: 0
			loop: 3
			setStep: 3 2
			offset: 3
			posn: 152 166
			ignoreActors: 0
			illegalBits: $8000
		)
		(employee moveSpeed: 1 ignoreActors: 0 setScript: helpCounter init:)
		(empHand init:)
		(mouth init: posn: (curtain x:) (curtain y:) 1000)
		(tailor setCycle: Walk ignoreActors: 0 observeControl: 2 init:)
		(gCurRoom setScript: greet)
		(if (IsFlag 59)
			(++ local4)
		)
		(if (== ((gInventory at: 26) owner:) 203) ; Cloak
			(cloak init:)
		)
		(curtain init:)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: local7)
		(DisposeScript 975)
		(DisposeScript 985)
		(gGlobalSound fade:)
		(super dispose:)
	)
)

(instance greet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: MoveTo 152 152 self)
			)
			(2
				(Say 105 203 0 67 10 10 25 4) ; "May I help you, sir?"
				(tailor setMotion: Follow gEgo 40)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance soldCloak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((gEgo has: 26) ; Cloak
						(PrintDC 203 1) ; "Graham sees nothing else of interest in the tailor's shop."
						(client setScript: 0)
						(HandsOn)
					)
					((& (gEgo onControl: 0) $0010)
						(gEgo setMotion: MoveTo 197 128 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo (- (tailor x:) 8) (+ (tailor y:) 8) self
				)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 24
					loop: 0
					cel: 0
					setAvoider: 0
					ignoreControl: 8192
					setCycle: End self
				)
			)
			(3
				(tailor
					setMotion: 0
					view: 164
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(4
				(gEgo setCycle: Beg self)
				(tailor setCycle: Beg self)
			)
			(5)
			(6
				(gEgo view: 0 normal: 1 loop: 3 setCycle: Walk)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(7
				(RedrawCast)
				(switch local6
					(0
						(gEgo get: 26) ; Cloak
						(gEgo put: 3 203) ; Golden_Needle
						(SetScore 4)
						(Say 105 203 2 67 10 10 25 7) ; "My golden needle! Wherever did you find it?"
						(RedrawCast)
						(Say 160 203 3 67 10 10 25 7) ; "It was found in a haystack by the inn."
						(RedrawCast)
						(Say 105 203 4 67 10 10 25 15) ; "By the inn? Oh, yes. I remember visiting there not long ago. Vulgar man, that innkeeper! He has no scruples at all."
						(RedrawCast)
						(Say 160 203 5 67 10 10 25 7) ; "Well, I'm glad to see you've got your golden needle back."
						(RedrawCast)
						(Say 160 203 6 67 10 10 25 9) ; "I wonder...could you possibly see fit to give me that wonderful cloak in exchange for it?"
						(RedrawCast)
						(Say 105 203 7 67 10 10 25 10) ; "The cloak? Well, why not. It's yours...for the price of a golden needle!"
					)
					(1
						(gEgo get: 26) ; Cloak
						(gEgo put: 11 203) ; Gold_Coin
						(Say 160 203 8 67 10 10 25 9) ; "I would like to buy that fine cloak hanging in the corner. Will you take a gold coin for it?"
						(RedrawCast)
						(Say 105 203 9 67 10 10 25 10) ; "Why, yes. I guess a gold coin would be adequate. Here...let me get it for you."
					)
					(2
						(gEgo get: 26) ; Cloak
						(gEgo put: 9 203) ; Heart
						(Say 160 203 10 67 10 10 25 9) ; "I would like to buy that fine cloak hanging in the corner. Will you take a lovely golden heart for it?"
						(RedrawCast)
						(Say 105 203 11 67 10 10 25 10) ; "This is a lovely piece! Of COURSE you may buy the cloak with this! Here...let me get it for you."
					)
				)
				(tailor
					view: 162
					setCycle: Walk
					ignoreControl: 2
					setAvoider: (Avoid new:)
					setMotion: MoveTo 216 127 self
				)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 133 self
				)
			)
			(8)
			(9
				(tailor
					view: 164
					loop: 3
					cel: 0
					setPri: 7
					setAvoider: 0
					setCycle: End self
				)
				(gEgo loop: 7 cel: 3 setAvoider: 0)
				(cloak dispose:)
			)
			(10
				(tailor loop: 4 cel: 0 setCycle: End self)
			)
			(11
				(Say 160 203 12 67 10 10 25 7) ; "Thank you, kind sir. I'm sure it will help me in my travels."
				(RedrawCast)
				(Say 105 203 13 67 10 10 25 7) ; "I'm sure it will. Good luck...au revoir."
				(tailor
					setScript: 0
					view: 162
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setPri: -1
					illegalBits: $0800
					setAvoider: (Avoid new:)
					setMotion: MoveTo 202 116 self
				)
			)
			(12
				(tailor setPri: 7 setMotion: MoveTo 152 116 self)
			)
			(13
				(tailor loop: 2 setAvoider: 0)
				(gEgo view: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance helpWithCloak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tailor
					ignoreControl: 2
					setAvoider: (Avoid new:)
					setMotion: MoveTo 216 127 self
				)
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 205 133 self
				)
			)
			(1)
			(2
				(gEgo loop: 11 cel: 4 setAvoider: 0)
				(cloak hide:)
				(tailor
					view: 164
					loop: 3
					setPri: 7
					cel: 0
					setAvoider: 0
					setCycle: End self
				)
			)
			(3
				(tailor loop: 4 cel: 0 setCycle: End self)
			)
			(4
				(gEgo view: 10)
				(tailor view: 162 loop: 2)
				(RedrawCast)
				(Say 105 203 14 67 10 10 25 7) ; "Oh, that cloak fits you PERFECTLY! It just looks WONDERFUL on you!"
				(RedrawCast)
				(Say 105 203 15 67 10 10 25 7) ; "Let me tell you... it will certainly keep you toasty warm during the coming winter."
				(RedrawCast)
				(Say 105 203 16 67 10 10 25 5) ; "Let me know if you wish to buy it."
				(gEgo view: 0)
				(tailor view: 164 loop: 4 setCycle: Beg self)
			)
			(5
				(tailor loop: 3 cel: 7 setCycle: Beg self)
			)
			(6
				(cloak show:)
				(tailor
					view: 162
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					setPri: -1
					setMotion: MoveTo 183 129 self
				)
			)
			(7
				(tailor observeControl: 2 setMotion: Follow gEgo 40)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance helpCounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(employee
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 125 112 self
				)
			)
			(1
				(employee setLoop: 0 cel: 0 setCycle: End)
				(empHand cel: (Random 0 3))
				(= seconds 5)
			)
			(2
				(employee setCycle: Beg self)
			)
			(3
				(employee
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 210 112 self
				)
			)
			(4
				(employee setLoop: 1 setCycle: End)
				(= seconds 5)
			)
			(5
				(curtain setCycle: End)
				(gGlobalSound3 number: 859 loop: 1 vol: 127 play:)
				(= seconds 10)
			)
			(6
				(curtain setCycle: Beg self)
				(gGlobalSound3 number: 859 loop: 1 vol: 127 play:)
			)
			(7
				(mouth z: 34 setCycle: RandCycle)
				(if (not (gCurRoom script:))
					(switch local5
						(0
							(PrintDC 203 17 #at 40 10 #time 4 #dispose) ; "I don't like THIS at all!"
						)
						(1
							(PrintDC 203 18 #at 40 10 #time 4 #dispose) ; "You expect me to wear THIS!"
						)
						(2
							(PrintDC 203 19 #at 40 10 #time 5 #dispose) ; "Why, these trousers don't even fit!"
						)
						(3
							(PrintDC 203 20 #at 40 10 #time 5 #dispose) ; "This shirt's too tight in the shoulders!"
						)
						(4
							(PrintDC 203 21 #at 40 10 #time 4 #dispose) ; "This isn't my style at all!"
						)
						(5
							(PrintDC 203 22 #at 40 10 #time 5 #dispose) ; "Take these back. I don't like any of them."
						)
						(6
							(PrintDC 203 23 #at 40 10 #time 4 #dispose) ; "The sleeves aren't long enough!"
						)
						(7
							(PrintDC 203 24 #at 40 10 #time 5 #dispose) ; "This material's too thin. I like something thicker."
						)
						(8
							(PrintDC 203 25 #at 40 10 #time 5 #dispose) ; "How am I supposed to get my boots on over these trousers?"
						)
						(9
							(PrintDC 203 26 #at 40 10 #time 4 #dispose) ; "This tie isn't the right color."
						)
						(10
							(PrintDC 203 27 #at 40 10 #time 4 #dispose) ; "Here, take this. Let me try on another one."
						)
					)
					(if (< local5 10)
						(++ local5)
					else
						(= local5 0)
					)
				)
				(= seconds 4)
			)
			(8
				(mouth z: 1000 setCycle: 0)
				(self init:)
			)
		)
	)
)

(instance tailorTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_7 gEgo tailor 5)
				(proc0_7 tailor gEgo 5)
				(= cycles 2)
			)
			(1
				(Say 160 203 28 67 10 10 25 5) ; "I'm interested in buying something."
				(RedrawCast)
				(Say 105 203 29 67 10 10 25 5) ; "Ah! Let me show you some things."
				(RedrawCast)
				(tailor
					setScript: 0
					view: 162
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					illegalBits: $0800
					setAvoider: (Avoid new:)
					setMotion: MoveTo 202 116 self
				)
			)
			(2
				(tailor setPri: 7 setMotion: MoveTo 152 116 self)
				(if (> (gEgo y:) 116)
					(gEgo setMotion: PolyPath 142 126 self)
				)
			)
			(3
				(if (and (not (gEgo mover:)) (< (gEgo y:) 126))
					(gEgo setMotion: PolyPath 142 126 self)
				)
			)
			(4
				(proc0_7 tailor gEgo)
				(gEgo loop: 7 cel: 3)
				(RedrawCast)
				(Say 105 203 30 67 10 100 25 8) ; "A fine piece of cloth. With this material I could make you beautiful shirts."
				(RedrawCast)
				(Say 105 203 31 67 10 100 70 280 25 14) ; "There isn't a more beautiful piece of fabric to be found anywhere! With this, I could make you the finest trousers you've ever had."
				(RedrawCast)
				(Say 105 203 32 67 10 100 25 5) ; "Well, what do you think?"
				(RedrawCast)
				(Say 160 203 33 67 100 100 25 8) ; "Well, right now I'm just looking. Thanks anyway."
				(RedrawCast)
				(Say 105 203 34 67 10 100 25 8) ; "Sure, sure. Whatever you say. I'm just here to help."
				(tailor
					view: 162
					cycleSpeed: 0
					setLoop: -1
					setCycle: Walk
					illegalBits: $0800
					setMotion: MoveTo 195 116 self
				)
			)
			(5
				(tailor setPri: -1 setMotion: MoveTo 195 132 self)
			)
			(6
				(tailor
					setCycle: Walk
					ignoreActors: 0
					setAvoider: 0
					observeControl: 2
					setMotion: Follow gEgo 40
					init:
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance tailor of Act
	(properties
		y 142
		x 149
		view 162
		loop 2
		signal 16384
		illegalBits $0800
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and (not (gCurRoom script:)) (== ((gInventory at: 26) owner:) 203)) ; Cloak
			(if (> (gEgo distanceTo: tailor) 40)
				(if (not (self mover:))
					(self
						moveSpeed: (gEgo moveSpeed:)
						setMotion: Follow gEgo 40
					)
				)
			else
				(proc0_7 tailor gEgo 5)
				(= temp0 (tailor loop:))
				(self cel: temp0 loop: 7 setMotion: 0)
			)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (gEgo has: 26) ; Cloak
						(PrintDC 203 35 #at 20 20) ; "The tailor hopes that Graham will be happy with his newly-purchased cloak."
					else
						(PrintDC 203 36 #at 20 20) ; "The tailor, an aristocratic-looking man, attends solicitously to Graham as he looks at the wares in the tailorshop."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((== ((gInventory at: 3) owner:) 203) ; Golden_Needle
							(PrintDC 203 37 #at 20 20) ; "Having lost all interest in Graham, the tailor now attends to other business."
							(event claimed: 1)
						)
						((not local0)
							(++ local0)
							(PrintDC 203 38 #at 20 20) ; "Being a good businessman, the solicitous tailor would love to sell something to Graham."
							(event claimed: 1)
						)
					)
				)
				(5 ; Inventory
					(switch global69
						(3 ; Golden_Needle
							(= local6 0)
							(HandsOff)
							(gCurRoom setScript: soldCloak)
							(event claimed: 1)
						)
						(4 ; Coin
							(if (not (gEgo has: 26)) ; Cloak
								(proc0_7 gEgo tailor 5)
								(RedrawCast)
								((gEgo head:)
									cel:
										(switch (gEgo loop:)
											(0 1)
											(1 5)
											(2 3)
											(3 7)
										)
									forceUpd:
								)
								(RedrawCast)
								(Say 160 203 39 67 20 20 25 10) ; "I would like to buy that fine cloak hanging in the corner. Will you take a silver coin for it?"
								(Say 105 203 40 67 20 20 25 10) ; "A silver coin! You MUST be joking! That beautiful cloak is worth MUCH more than that!"
							else
								(proc0_7 gEgo tailor 5)
								(RedrawCast)
								((gEgo head:)
									cel:
										(switch (gEgo loop:)
											(0 1)
											(1 5)
											(2 3)
											(3 7)
										)
									forceUpd:
								)
								(RedrawCast)
								(Say 105 203 41 67 20 20 25 8) ; "I'm afraid I have nothing else in my shop at that price."
							)
							(event claimed: 1)
						)
						(11 ; Gold_Coin
							(= local6 1)
							(gCurRoom setScript: soldCloak)
							(event claimed: 1)
						)
						(9 ; Heart
							(= local6 2)
							(gCurRoom setScript: soldCloak)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(if (gEgo has: 26) ; Cloak
								(PrintDC 203 1) ; "Graham sees nothing else of interest in the tailor's shop."
							else
								(PrintDC 203 42) ; "The tailor wouldn't find that suitable for his business."
							)
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(switch local4
						(0
							(if (gEgo has: 26) ; Cloak
								(PrintDC 203 1) ; "Graham sees nothing else of interest in the tailor's shop."
							else
								(SetFlag 59)
								(++ local4)
								(HandsOff)
								(gCurRoom setScript: tailorTalk)
							)
							(event claimed: 1)
						)
						(1
							(PrintDC 203 43 #at 20 20) ; "Not wishing to be put through another speech about fine shirts and trousers, Graham wisely keeps his mouth shut."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance cloak of Prop
	(properties
		y 123
		x 233
		view 176
		loop 9
		signal 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 203 44 #at 20 20) ; "In the corner of the shop, draped casually over a tailor's form, Graham sees a thick, fur-lined cloak."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local3)
						(++ local3)
						(HandsOff)
						(Say 105 203 45 67 20 20 25 6) ; "Here. Let me help you with that."
						(gCurRoom setScript: helpWithCloak)
					else
						(Say 105 203 46 67 20 20 25 6) ; "It's a fine cloak. It could be very useful."
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(3 ; Golden_Needle
							(= local6 0)
							(HandsOff)
							(gCurRoom setScript: soldCloak)
							(event claimed: 1)
						)
						(4 ; Coin
							(proc0_7 gEgo tailor 5)
							(RedrawCast)
							((gEgo head:)
								cel:
									(switch (gEgo loop:)
										(0 1)
										(1 5)
										(2 3)
										(3 7)
									)
								forceUpd:
							)
							(RedrawCast)
							(Say 160 203 39 67 20 20 25 8) ; "I would like to buy that fine cloak hanging in the corner. Will you take a silver coin for it?"
							(Say 105 203 40 67 20 20 25 8) ; "A silver coin! You MUST be joking! That beautiful cloak is worth MUCH more than that!"
							(event claimed: 1)
						)
						(11 ; Gold_Coin
							(= local6 1)
							(gCurRoom setScript: soldCloak)
							(event claimed: 1)
						)
						(9 ; Heart
							(= local6 2)
							(gCurRoom setScript: soldCloak)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(26 ; Cloak
							(Say 105 203 47 67 20 20 25 7) ; "I hope you enjoy your fine cloak."
							(event claimed: 1)
						)
						(else
							(Say 105 203 48 67 20 20 25 10) ; "No, that doesn't even begin to cover the cost of the material."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance curtain of Prop
	(properties
		y 108
		x 204
		view 176
		loop 5
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 203 49 #at 10 10) ; "At the back of the shop, Graham notices a dressing room in which a finicky customer tries on, and rudely rejects, many items of fine clothing."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 203 50 #at 10 10) ; "The dressing room appears to be occupied at the moment."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 203 51 #at 10 10) ; "The rude customer doesn't care to talk to Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mouth of Prop
	(properties
		view 176
		loop 10
		cycleSpeed 4
	)
)

(instance empHand of Prop
	(properties
		view 176
		loop 6
	)

	(method (doit)
		(super doit:)
		(self y: (employee y:) z: 18)
		(switch (employee loop:)
			(2
				(self x: (employee x:) loop: 6 show:)
			)
			(3
				(self x: (+ (employee x:) 7) loop: 7 show:)
			)
			(4
				(self x: (- (employee x:) 6) loop: 8 show:)
			)
			(else
				(self hide:)
			)
		)
	)
)

(instance employee of Act
	(properties
		y 112
		x 218
		view 176
		loop 1
		illegalBits $0800
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 203 52 #at 20 20) ; "An employee of the tailor, a friendly, good-looking young man, caters hopelessly to a disagreeable customer in the back dressing room."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 203 53 #at 10 10) ; "The young man is too busy with another customer to be bothered by Graham."
					(event claimed: 1)
				)
				(4 ; Talk
					(PrintDC 203 53 #at 10 10) ; "The young man is too busy with another customer to be bothered by Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance shopRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 203 54 #at 20 20) ; "The busy tailorshop bustles with activity as Graham looks around with interest at all the tailor's wares."
					(event claimed: 1)
				)
			)
		)
	)
)

