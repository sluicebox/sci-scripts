;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm640 0
)

(local
	theCounter
)

(instance rm640 of Rm
	(properties
		picture 640
	)

	(method (init)
		(Load rsSOUND 640)
		(Load rsSOUND 120)
		(Load rsPIC 99)
		(super init:)
		(gAddToPics
			add: atpChest
			add: atpWheel
			add: atpBarrel1
			add: atpBarrel2
			add: atpBarrel3
			add: atpBertaButt
			doit:
		)
		(aCamera init:)
		(aRosella init:)
		(aRoberta init:)
		(NormalActor aLarry 0 720)
		(aLarry posn: 8 174 init: stopUpd:)
		(self setScript: RoomScript)
		(= gOldGameSpeed (gGame setSpeed: 6))
		(NormalEgo 0)
		(gEgo posn: 12 183 init: stopUpd:)
		(HandsOff)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 640 0) ; "Truck that camera left!"
				(= seconds 2)
			)
			(2
				(aCamera setStep: 1 1 setMotion: MoveTo 96 189 self)
			)
			(3
				(Print 640 1) ; "No, no, no! Move back!"
				(aCamera setMotion: MoveTo 47 238 self)
			)
			(4
				(aCamera stopUpd:)
				(Print 640 2) ; ""Good, good. That's fine. Stop right there," barks the woman in the director's chair."
				(= seconds 2)
			)
			(5
				(Print 640 3) ; "Turning to the actress on the set, she says, "Now, Rosella, what do you say we take it again from the top, and this time really show me some emotion!""
				(gMusic fade:)
				(= seconds 2)
			)
			(6
				(Print 640 4) ; "And... ACTION!!"
				(aRoberta setCycle: End)
				(gMusic number: 640 loop: 1 play:)
				(= seconds 3)
			)
			(7
				(aRosella
					setStep: 2 2
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo 177 86 self
				)
			)
			(8
				(aRosella
					moveSpeed: 0
					cycleSpeed: 0
					setLoop: 5
					setStep: 2 4
					setMotion: MoveTo 177 123 self
				)
			)
			(9
				(aRoberta setCycle: Beg)
				(= cycles 15)
			)
			(10
				(aRosella setLoop: 0)
				(gMusic fade:)
				(switch (++ theCounter)
					(1
						(Print 640 5) ; "CUT!! No, that's no good. Try it from the right side this time!"
					)
					(2
						(Print 640 6) ; "No. CUT! You slipped again, Rosella!"
					)
					(3
						(aRosella stopUpd:)
						(Print 640 7) ; "CUT!! How many times must we do this, Rosella? You must get all the way up to that uvula!"
						(++ state)
					)
				)
				(= cycles 22)
			)
			(11
				(aRosella
					setLoop: 3
					setStep: 2 1
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: MoveTo 224 115 self
				)
				(if (< theCounter 3)
					(= state 5)
				)
			)
			(12
				(aRosella cycleSpeed: 1 setLoop: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(13
				(Print 640 8) ; ""What's going on here, Patti?" whispers Larry."
				(= seconds 2)
			)
			(14
				(Printf ; ""I don't know, Larry, but that girl certainly seems tired of going down %sthat tongue!"%"
					640
					9
					(if (>= gFilthLevel 3) {on } else {})
					(if (>= gFilthLevel 3) {sur } else {})
				)
				(aRosella setLoop: 1)
				(= seconds 2)
			)
			(15
				(Print 640 10) ; "This just isn't right!" whines the actress on the giant tongue set. "It's too humid in here. This wool skirt keeps soaking up water. That goo you spread on the tongue is too slippery. You haven't given me my motivation for this scene yet..."
				(Print 640 11) ; "Thank you very much, Rosella!" interrupts the woman in the director's chair. "If you have any other complaints, please don't let me stop you!"
				(aRoberta setCycle: End self)
			)
			(16
				(Print 640 12) ; "Well, yes I do!" she pouts, pointing directly at you and Larry. "I thought this was a `Closed Set!' Who are those two people over there?"
				(aRosella setLoop: 2)
				(= seconds 3)
			)
			(17
				(aRoberta setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(18
				(Print 640 13) ; ""CUT! BREAK!! Ten minutes, people," she shouts to the crew."
				(Print 640 14) ; "With an angry glare, she turns toward you and Larry, "And who are you? What are you doing here? How did you get in? Come over here, right now!""
				(aRoberta setCel: 0)
				(aRosella loop: 0 stopUpd:)
				(aCamera setMotion: MoveTo 41 244 self)
			)
			(19
				(gEgo setMotion: MoveTo 227 187 self)
				(= cycles 9)
			)
			(20
				(aLarry setMotion: MoveTo 239 176 self)
				(= cycles 22)
			)
			(21
				(Print 640 15) ; "As you move closer, you recognize the woman in the director's chair. "Why, Larry, look! It's Roberta Williams!""
				(= cycles 11)
			)
			(22
				(Print 640 16) ; "To her, you cry, "Oh, Ms. Williams! I've loved your games for years! What an honor this is... to finally meet my software hero!""
				(gMusic number: 699 loop: -1 play:)
				(aRoberta setCycle: Fwd)
			)
			(23
				(Print 640 17) ; "Roberta softens noticeably, "Well, yes, I... I, uh, am Roberta Williams. But who are you?""
				(aRoberta setCel: 0)
				(= seconds 3)
			)
			(24
				(aLarry loop: 2 forceUpd: stopUpd:)
				(Print 640 18) ; "Well, Roberta, I'm Passionate Patti, the world-famous lounge pianist. The gentleman to your right is my lover. His name is Larry; Larry Laffer!"
				(aRoberta setCycle: Fwd)
				(= seconds 2)
			)
			(25
				(Print 640 19) ; "Nice to meet you both," says Roberta, "but how did you get in here? This is supposed to be a high-security area!"
				(aRoberta setCel: 0)
				(= seconds 2)
			)
			(26
				(Print 640 20) ; ""We just dropped in... literally!" offers Larry."
				(Print 640 21 #at 10 -1 #width 290) ; "Actually, Berta, we've had one hell of an adventure just getting here. Why, I've been through a virtual maze of bamboo forest with just one drink of water; rappelled down a sheer cliff on a pair of pantyhose; crossed an incredible chasm with only a handmade rope; fought ferocious feral swine with my underwear; ridden a log through a whitewater canyon; and..."
				(Print 640 22) ; "O.K. already! Enough, enough," laughs Roberta. "But what about him?"
				(= seconds 2)
			)
			(27
				(Print 640 23) ; "I, I," Larry stammers, "I've had quite a few adventures in my day, too!"
				(Print 640 24) ; "Oh, really?" replies Roberta, "anything that might make an adventure game?"
				(= seconds 3)
			)
			(28
				(Print 640 25) ; "Of course, it would, Bert!" you brag confidently. "If you could just set us up with a little place to work (up to my reasonable standards, of course) we would write a whole series of adventure games for you!"
				(= seconds 3)
			)
			(29
				(Print 640 26) ; "We could discuss this over lunch," Larry interrupts, "I haven't eaten a thing this entire game!"
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= cycles 22)
			)
			(30
				(Print 640 27) ; "As the three of you head off together, Roberta says, "We do have a home on the lake; would that adequately meet your needs, Patti?""
				(gMusic fade:)
				(= seconds 6)
			)
			(31
				(gMusic number: 120 loop: -1 play:)
				(= seconds 3)
			)
			(32
				(Print 640 28 #time (= temp0 (LangSwitch 4 4 8 8)) #dispose) ; "And so it ends."
				(= seconds (+ temp0 1))
			)
			(33
				(PrintSplit 640 29) ; "Larry and Patti move in together, sharing a simple programmer's shack in the mountains. Patti gives up her musician's life on the road for the one man she found able to match her passion. Larry begins to tell the world his life story through software..."
				(= seconds 3)
			)
			(34
				(gCurRoom newRoom: 650)
			)
		)
	)
)

(instance aLarry of Act
	(properties)
)

(instance atpChest of PV
	(properties
		y 142
		x 89
		view 640
		signal 16384
	)
)

(instance atpWheel of PV
	(properties
		y 141
		x 159
		view 640
		cel 1
		priority 10
		signal 16384
	)
)

(instance atpBarrel1 of PV
	(properties
		y 137
		x 250
		view 640
		cel 2
		priority 9
		signal 16384
	)
)

(instance atpBarrel2 of PV
	(properties
		y 134
		x 47
		view 640
		cel 3
		priority 9
		signal 16384
	)
)

(instance atpBarrel3 of PV
	(properties
		y 135
		x 209
		view 640
		cel 4
		priority 9
		signal 16384
	)
)

(instance atpBertaButt of PV
	(properties
		y 166
		x 257
		view 643
		loop 3
		priority 15
	)
)

(instance aRoberta of Prop
	(properties
		y 166
		x 257
		view 643
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 15)
	)
)

(instance aCamera of Act
	(properties
		y 189
		x 120
		view 640
		loop 1
		illegalBits 0
	)
)

(instance aRosella of Act
	(properties
		y 126
		x 177
		view 644
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			illegalBits: 0
			setStep: 2 1
			setCycle: Walk
			setLoop: 4
		)
	)
)

