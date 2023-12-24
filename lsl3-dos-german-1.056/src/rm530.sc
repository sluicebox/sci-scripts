;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	attempts
	onOtherSide
	moveCounter
	potState
	[string 120]
	[string2 66]
)

(instance rm530 of Rm
	(properties
		picture 530
		horizon 1
	)

	(method (init)
		(Load rsVIEW 813)
		(Load rsSOUND 4)
		(Load rsSCRIPT 991)
		(cls)
		(super init:)
		(self setScript: RoomScript)
		(aRope init:)
		(if (!= gPrevRoomNum 525)
			(gMusic number: 599 loop: gBgMusicLoops play:)
		)
		(cond
			((== gPrevRoomNum 535)
				(= gEgoIsPatti 1)
				(= onOtherSide 1)
				(= potState 531)
				(= gNormalEgoView 802)
				(NormalEgo 2)
				(gEgo setStep: 2 1 posn: 215 75 init:)
				(aRope posn: 227 72 setCycle: End RopeScript)
			)
			((== gPrevRoomNum 540)
				(= gEgoIsPatti 1)
				(= onOtherSide 1)
				(= potState 531)
				(= gNormalEgoView 802)
				(NormalEgo 2)
				(gEgo setStep: 2 1 posn: 31 78 init:)
				(aRope posn: 227 72 setCel: 255 stopUpd:)
			)
			(else
				(= gEgoIsPatti 1)
				(= gNormalEgoView 800)
				(Load rsVIEW 531)
				(Load rsVIEW 532)
				(Load rsVIEW 533)
				(Load rsVIEW 534)
				(Load rsVIEW 804)
				(Load rsVIEW 20)
				(Load rsVIEW 27)
				(Load rsSOUND 531)
				(Load rsSOUND 530)
				(Load rsSOUND 12)
				(Load rsSOUND 599)
				(gMusic number: 4 loop: 1 play:)
				(= gEgoState 530)
				(gEgo
					ignoreActors:
					ignoreHorizon:
					view: 804
					setLoop: 0
					setCycle: Fwd
					setStep: 1 8
					setPri: 12
					illegalBits: 0
					posn: 170 -99
					init:
				)
				(RoomScript changeState: 1)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(== (gEgo view:) 534)
					(== (gEgo loop:) 1)
					(== (gEgo cel:) 1)
				)
				(gSoundFX number: 530 loop: 1 play:)
			)
			((and (& (gEgo onControl:) $0002) (== gEgoState 0))
				(= gEgoState 2)
				(gEgo posn: (- (gEgo x:) 25) (gEgo y:))
				(self changeState: 65)
			)
			((and (& (gEgo onControl:) $0080) (== gEgoState 0))
				(= gEgoState 2)
				(gEgo posn: (+ (gEgo x:) 25) (gEgo y:))
				(self changeState: 65)
			)
			((and (& (gEgo onControl:) $0040) (== gEgoState 0))
				(= gEgoState 2)
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 5))
				(self changeState: 65)
			)
			((& (gEgo onControl:) $0400)
				(gCurRoom newRoom: 540)
			)
			(
				(and
					(== potState 3)
					(or (!= 142 (gEgo x:)) (!= 128 (gEgo y:)))
				)
				(= potState 531)
				(self changeState: 58)
			)
			((and (== gEgoState 0) (not (TestFlag 6)) (not onOtherSide))
				(cond
					((== gSecondsInRoom 30)
						(++ gSecondsInRoom)
						(Print 530 0) ; "You feel a little thirsty."
					)
					((== gSecondsInRoom 60)
						(++ gSecondsInRoom)
						(Print 530 1) ; "You feel VERY thirsty!"
					)
					((or (> gSecondsInRoom 90) (== potState 4))
						(self changeState: 12)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'make,weave/dope,lasso,hemp')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(onOtherSide
						(Print 530 2) ; "You can't; there is no suitable fiber here!"
					)
					(else
						(switch potState
							(0
								(Print 530 3) ; "Good idea, but you presently have nothing with which to make a rope."
							)
							(1
								(self changeState: 44)
							)
							(else
								(Print 530 4) ; "You have enough rope."
							)
						)
					)
				)
			)
			((and (>= potState 4) (Said 'unfasten'))
				(Print 530 5) ; "You'd be happier if you did not!"
			)
			((or (Said 'lasso,hemp/boulder') (Said 'throw/dope,lasso,hemp'))
				(if (!= gEgoState 0)
					(NotNow) ; "Good idea. You might try that again later."
				else
					(switch potState
						(0
							(Print 530 6) ; "That's a thought, but what will you use?"
						)
						(1
							(Print 530 7) ; "You carelessly throw your marijuana to the winds."
							(gEgo put: 20 gCurRoomNum) ; Marijuana
							(= potState 0)
						)
						(2
							(if (not (& (gEgo onControl:) $0004))
								(Print 530 8) ; "Move a little closer to the edge, Patti."
							else
								(self changeState: 46)
							)
						)
						(3
							(ItIs) ; "It is."
						)
						(4
							(ItIs) ; "It is."
						)
						(531
							(Print 530 9) ; "There's no way you can lasso that palm tree from over here! You're stuck on this side of the canyon."
						)
					)
				)
			)
			((Said 'attach/lasso,hemp>')
				(cond
					((Said '//coconut')
						(Print 530 10) ; "You could never hang by your nuts!"
					)
					((!= gEgoState 531)
						(event claimed: 1)
						(Print 530 11) ; "A good idea, but slightly premature."
					)
					((Said '/[/!*]')
						(Print 530 12) ; "To what?"
					)
					((Said '//bureau,palm')
						(switch potState
							(2
								(Print 530 11) ; "A good idea, but slightly premature."
							)
							(3
								(self changeState: 53)
							)
							(4
								(ItIs) ; "It is."
							)
							(531
								(Print 530 13) ; "You'll never be able to tie a knot around that tree from over here!"
							)
							(else
								(Print 530 14) ; "Rope? What rope?"
							)
						)
					)
				)
			)
			(
				(or
					(Said
						'make/belt,belt,throw,cast,belt,belt,barstool,belt,belt'
					)
					(Said 'attach/lasso,hemp/me,self,entertainer')
					(Said 'use/dress,dress')
					(Said 'break/skirt,cloth,dress,dress')
					(Said 'germantearclothes')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((== gNormalEgoView 803)
						(Print 530 15) ; "You already did that."
					)
					((< potState 3)
						(Print 530 16) ; "An excellent idea, but slightly premature."
					)
					((< potState 4)
						(Print 530 17) ; "If you did that now, you'd have to turn loose of the rope!"
					)
					((> potState 4)
						(Print 530 18) ; "It's too late now, Patti."
					)
					(else
						(self changeState: 56)
					)
				)
			)
			(
				(or
					(Said 'cross/canyon,lasso,hemp')
					(Said 'cross//canyon,lasso,hemp')
					(Said
						'fuck,fuck,go,grab,exit,walk,use,climb/lasso,hemp,belt,belt'
					)
					(Said
						'fuck,fuck,go,grab,exit,walk,use,climb//lasso,hemp,belt,belt'
					)
				)
				(cond
					((!= gEgoState 0)
						(Print 530 19) ; "How can you do that?"
					)
					(onOtherSide
						(Print 530 20) ; "It's too late for that. There's no way to get back to the ledge from here."
					)
					((< potState 4)
						(Print 530 21) ; "Good idea, but not just yet."
					)
					((> 129 (gEgo y:))
						(NotClose) ; "You're not close enough."
					)
					(else
						(self changeState: 60)
					)
				)
			)
			((and onOtherSide (Said '/lasso,hemp'))
				(Print 530 22) ; "Your rope is hanging from the rock, but at such an angle and so near the edge of the cliff that you dare not take it."
			)
			((and potState (Said 'test,look,look/lasso,hemp,knot'))
				(Print 530 23) ; "It might be okay."
			)
			((and (== potState 3) (Said 'use,climb,throw/lasso,hemp'))
				(Print 530 24) ; "That's not the answer, Patti. If you did that, you'd crash into that cliff over there!"
			)
			((Said 'climb/bureau,palm')
				(cond
					((== gEgoState 536)
						(self changeState: 42)
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(onOtherSide
						(Print 530 25) ; "There are no trees near you."
					)
					((& (gEgo onControl:) $0020)
						(Print 530 26) ; "Move over until you are near the other tree."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 530 27) ; "There are trees here, but none close enough for you to climb."
					)
					(else
						(self changeState: 35)
					)
				)
			)
			((and (== gEgoState 536) (Said 'go,climb<down'))
				(self changeState: 42)
			)
			((Said 'pick,get,get/coconut')
				(cond
					((gEgo has: 19) ; Coconuts
						(Print 530 28) ; "You already have a lovely set of coconuts, Patti!"
					)
					((!= gEgoState 536)
						(Print 530 29) ; "The coconuts hang below the fronds at the top of the tree. There's no way you could reach them from here, Patti."
					)
					(else
						(self changeState: 37)
					)
				)
			)
			((Said 'climb[<down]/boulder,canyon,ledge')
				(Print 530 30) ; "There's no way you could possibly scale these rocks."
				(Print 530 31 #at -1 144) ; "(Especially in that white dress!)"
			)
			((Said 'climb<up[/boulder,canyon,ledge]')
				(Print 530 32) ; "You'll never be able to return up there, Patti."
			)
			((or (Said 'look,look<down') (Said 'look,look/cliff,edge,canyon'))
				(Print 530 33) ; "It's a long way to the bottom of that canyon. Be careful, Patti!"
			)
			(
				(and
					(not onOtherSide)
					(or
						(Said 'look,look/air,hose')
						(Said 'climb/cliff,cliff,cliff')
						(Said 'look,look<up')
					)
				)
				(Print 530 34) ; "It's a long way back up to that stream and waterfall!"
				(Print 530 35) ; "High above your head hangs the remains of your poor pantyhose, twisting slowly, slowly in the wind."
			)
			((Said 'pick,get,get/dope,plant,bush,farm,hemp')
				(if (!= gEgoState 0)
					(NotNow) ; "Good idea. You might try that again later."
				else
					(switch potState
						(0
							(if (not (& (gEgo onControl:) $0008))
								(NotClose) ; "You're not close enough."
							else
								(self changeState: 7)
							)
						)
						(1
							(Print 530 36) ; "You have all you need. The question is: what are you going to do with what you've got?"
						)
						(2
							(Print 530 37) ; "You have enough hemp rope to meet your needs."
						)
						(else
							(Print 530 38) ; "You need no more at this time."
						)
					)
				)
			)
			(
				(or
					(Said 'make,pull,pull/dope')
					(Said 'burn,burn,smoke/plant,bush,farm,dope')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 20)) ; Marijuana
						(Print 530 39) ; "You have nothing to smoke."
					)
					((> potState 1)
						(Print 530 40) ; "It's too late to smoke it -- you turned it into a rope, remember?"
					)
					(else
						(= gEgoState 534)
						(self changeState: 15)
					)
				)
			)
			(
				(or
					(Said 'drop/blade,dope,farm/lip')
					(Said 'eat,eat,eat/plant,bush,farm,dope')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 20)) ; Marijuana
						(Print 530 41) ; "You have no marijuana."
					)
					((> potState 1)
						(Print 530 42) ; "It's too late for that -- you turned it into a rope, remember?"
					)
					(else
						(= gEgoState 535)
						(self changeState: 15)
					)
				)
			)
			((Said 'unfasten')
				(Print 530 43) ; "That's unnecessary."
			)
			((Said 'move,pull,pull,pull/bureau,palm')
				(Print 530 44) ; "Shaking won't help. You must go right to the source, Patti!"
			)
			(
				(and
					(gEgo has: 19) ; Coconuts
					(or
						(Said 'use,attach/coconut')
						(Said 'use,attach//coconut')
					)
				)
				(Print 530 45) ; "There will come a time when you may make use of those coconuts. This is just not it!"
			)
			((Said 'look,look>')
				(cond
					((Said '/boulder')
						(cond
							((== potState 531)
								(Print 530 22) ; "Your rope is hanging from the rock, but at such an angle and so near the edge of the cliff that you dare not take it."
							)
							((== potState 4)
								(Print 530 46) ; "It looks secure enough."
								(Print 530 47 #at -1 144) ; "(But is it?)"
							)
							(else
								(Print 530 48) ; "Across the canyon is a rock that rises to a point. Get the point?"
							)
						)
					)
					((Said '/carpet')
						(Print 530 49) ; "Two small depressions indicate your landing point."
					)
					((Said '/bureau,palm')
						(cond
							(onOtherSide
								(Print 530 50) ; "A path to the northwest leads through the trees and away from here."
							)
							((== gEgoState 536)
								(Print 530 51) ; "Since your legs are wrapped around it, the tree is two inches from your nose and quite easy to see!"
							)
							(else
								(Print 530 52) ; "Looking up under the fronds, you can see that these are coconut palms."
							)
						)
					)
					((Said '/coconut')
						(if (>= gFilthLevel 2)
							(Print 530 53 #at -1 144) ; "(You now realize you've been waiting for a chance to type that this entire game!)"
						)
						(cond
							((gEgo has: 19) ; Coconuts
								(event claimed: 0)
							)
							(onOtherSide
								(Print 530 54) ; "From over here, you think you may be able to make out a faint outline of some coconuts hanging beneath the leaves of the palm tree to which you tied your rope."
							)
							(else
								(Print 530 55) ; "Peeking beneath the palm trees' fronds, you can see that these trees have large, brown nuts."
								(Print 530 56) ; "You surmise they are coconut palms."
							)
						)
					)
					(
						(and
							(not (gEgo has: 20)) ; Marijuana
							(or (Said '/dope') (Said '/plant,bush,exit'))
						)
						(if (== gEgoState 536)
							(Print 530 57) ; "Carefully peering beneath the overhanging fronds, you observe this is a male of the species."
						else
							(Print 530 58) ; "Dr. Nonookee, the evil genius that your Leisure Suit Larry defeated in "Looking for Love (in Several Wrong Places)," planted this garden many years ago. He must have used a helicopter for harvesting!"
						)
					)
					((Said '/plant,bush,exit')
						(cond
							((== gEgoState 536)
								(Print 530 57) ; "Carefully peering beneath the overhanging fronds, you observe this is a male of the species."
							)
							(onOtherSide
								(Print 530 59) ; "There is a small opening in the brush towards the northwest."
							)
							(else
								(Print 530 60) ; "Wait a minute! You've seen those leaves in pamphlets from the Surgeon General's office. Why, that stuff's marijuana! You must have tumbled into what's left of Dr. Nonookee's private stash!"
							)
						)
					)
					((Said '[/ledge,area]')
						(cond
							((== gEgoState 536)
								(Print 530 61) ; "From up here, you can see a long way. Across the canyon you catch a glimpse of running water and flashes of pink through the jungle growth."
							)
							(onOtherSide
								(Print 530 62) ; "There is a small opening in the brush towards the northwest. There's no reason to mess around here, Patti. Your destination lies before you."
							)
							(else
								(Print 530 63) ; "Your three-point landing has left you upon a small ledge projecting from the face of the cliff. All around you are plants with unusually shaped leaves."
							)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo
					ignoreActors:
					setStep: 1 1
					setMotion: JumpTo 170 155 self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0)
				(gMusic number: 12 loop: 1 play:)
				(ShakeScreen 3 ssUPDOWN)
				(= seconds 4)
			)
			(3
				(Print 530 64) ; "You slowly recover from your near-tragic pantyhosing, and try to remember why you are here."
				(= seconds 4)
			)
			(4
				(Print 530 65) ; "Of course! It's Larry you're seeking. You bring yourself back to your feet, ready to again resume your quest for the man of your dreams!"
				(= seconds 4)
			)
			(5
				(gEgo setCycle: End self)
				(gAddToPics add: atpTits doit:)
			)
			(6
				(gMusic number: 599 loop: gBgMusicLoops play:)
				(gEgo posn: 170 155 cel: 1)
				(NormalEgo 2)
				(= gEgoState 0)
				(gGame setSpeed: gOldGameSpeed)
			)
			(7
				(if (not (TestFlag 58))
					(SetFlag 58) ; pickedPot
					(gGame changeScore: 10)
				)
				(Ok) ; "O.K."
				(Print 530 66) ; "You bend over and gather a few choice products from Dr. Nonookee's garden of unearthly delights."
				(HandsOff)
				(= moveCounter 0)
				(gEgo
					view: 531
					cycleSpeed: 1
					setStep: 2 1
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gEgo
					cycleSpeed: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo (Random 111 195) (gEgo y:) self
				)
			)
			(9
				(= cycles 11)
				(if (> 4 (++ moveCounter))
					(= state 7)
				)
			)
			(10
				(gEgo
					cycleSpeed: 1
					setLoop: 0
					setCel: 255
					setCycle: Beg self
				)
			)
			(11
				(NormalEgo)
				(= potState 1)
				(gEgo loop: 2 get: 20) ; Marijuana
				(Print 530 67) ; "Are you sure this is something you should be doing?"
			)
			(12
				(HandsOff)
				(= gEgoState 1001)
				(Print 530 68) ; "You feel your precious bodily fluids turn to dust!"
				(gEgo loop: 2)
				(gMusic fade:)
				(= seconds 3)
			)
			(13
				(gEgo view: 804 loop: 1 setCel: 255 setCycle: Beg self)
			)
			(14
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 537
					register: (Format @string 530 69) ; "You were so near... and yet, so far!%"
					next: (Format @string2 530 70) ; "A Little "Dry" Humor%"
				)
			)
			(15
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo setMotion: MoveTo 151 142 self)
				(gMusic fade:)
			)
			(16
				(gEgo view: 531 loop: 8 cel: 0 setCycle: End self)
				(= seconds 3)
			)
			(17
				(gGame changeScore: -50)
				(if (== gEgoState 535)
					(Print 530 71 #at -1 10 #icon 20 0 0) ; "You fill your mouth with marijuana leaves and slowly chew them..."
					(= state 24)
				else
					(Print 530 72 #at -1 10 #icon 20 0 0) ; "You quickly dry a few leaves in the sun, pull a pack of rolling papers from your bra and place the leaves in the paper while professionally executing a one-handed roll."
				)
				(= seconds 3)
			)
			(18
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(19
				(Print 530 73 #dispose #at -1 10) ; "Grabbing a couple of rocks, you slap them together until they make a spark that ignites your joint."
				(= moveCounter 0)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(20
				(gEgo loop: 4 cel: 0 setCycle: End self)
			)
			(21
				(if (> 3 (++ moveCounter))
					(= state 19)
				)
				(= cycles 20)
			)
			(22
				(gEgo loop: 5 cel: 0 setCycle: Fwd)
				(= cycles (* 3 (NumCels gEgo)))
			)
			(23
				(gEgo loop: 6 cel: 0 setCycle: End self)
			)
			(24
				(gEgo loop: 7 cel: 0 setCycle: End)
				(= cycles 44)
			)
			(25
				(Print 530 74 #dispose #at -1 10) ; "You begin to get a little buzz on."
				(gMusic number: 531 loop: -1 play:)
				(= seconds 3)
			)
			(26
				(gGame setSpeed: 6)
				(gEgo
					view: 533
					posn: (gEgo x:) (- (gEgo y:) 26)
					cycleSpeed: 1
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(27
				(gEgo
					put: 20 -1 ; Marijuana
					setLoop: 1
					cel: 0
					illegalBits: 0
					ignoreActors:
					setPri:
					setStep: 1 1
					setCycle: Fwd
					setMotion: MoveTo 232 91 self
				)
				(= cycles 11)
			)
			(28
				(Print 530 75 #dispose #at -1 10) ; "Whoa! What's happening?"
				(= cycles 11)
			)
			(29
				(Print 530 76 #dispose #at -1 10) ; "This stuff makes you feel like you're floating."
			)
			(30
				(Print 530 77 #dispose #at -1 10) ; "Looking down, you notice the ground seems far below you."
				(gEgo setPri: 2 setMotion: MoveTo 49 91 self)
				(= cycles 22)
			)
			(31
				(Print 530 78 #dispose #at -1 10) ; "Hey, cool, dude!"
				(= cycles 22)
			)
			(32
				(Print 530 79 #dispose #at -1 144) ; "(You see visions of Daventry!)"
			)
			(33
				(gMusic fade:)
				(Print 530 80 #dispose #at -1 10) ; "Aw, bogus! Is this stuff wearing off already?"
				(= seconds 3)
			)
			(34
				(= seconds (= cycles 0))
				(Print (Format @string 530 81 global289) #dispose #at -1 10) ; "%s"
				(gMusic number: 4 loop: 1 play:)
				(gEgo setLoop: 2 cel: 0 cycleSpeed: 0 setCycle: End self)
				(= state 65)
			)
			(35
				(Ok) ; "O.K."
				(HandsOff)
				(Print 530 82) ; "You wrap your slender thighs tightly around the long, cylindrical trunk."
				(if (>= gFilthLevel 3)
					(Print 530 83 #at -1 144) ; "(...an experience not wholly unfamiliar to you.)"
				)
				(= gEgoState 533)
				(gEgo
					view: 532
					setLoop: 0
					illegalBits: 0
					posn: 129 116
					setPri: 11
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 128 47 self
				)
			)
			(36
				(= gEgoState 536)
				(User canInput: 1)
			)
			(37
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(38
				(gEgo setLoop: 0 cel: 0 setCycle: End self)
			)
			(39
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(40
				(gEgo get: 19 setLoop: 0 cel: 0 setCycle: End self) ; Coconuts
			)
			(41
				(gGame changeScore: 25)
				(Print 530 84) ; "Reaching beneath the palm tree's frond kilt, you grab a pair of the large brown hairy nuts."
				(if (>= gFilthLevel 3)
					(Print 530 85 #at -1 144) ; "...an experience not wholly unfamiliar to you!"
				)
				(User canInput: 1)
			)
			(42
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo
					cycleSpeed: 1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 129 116 self
				)
			)
			(43
				(gEgo posn: 128 132)
				(NormalEgo 3)
				(= gEgoState 0)
			)
			(44
				(Ok) ; "O.K."
				(HandsOff)
				((Inv at: 20) view: 27) ; Marijuana
				(Format ((Inv at: 20) name:) 530 86) ; "Hemp Rope%", Marijuana
				(gGame changeScore: 100)
				(PrintSplit 530 87 67 -1 10 82 20 0 0) ; "Cleverly remembering that an original, legal use of marijuana was in the manufacture of hemp rope, you take the marijuana you harvested and carefully weave it into a rope. Fortunately, you picked enough so your rope is just slightly longer than the distance across that chasm."
				(= seconds 3)
			)
			(45
				(Print 530 88) ; "In other words, our little Muhammad Ali has made her own "dope-a-rope.""
				(= potState 2)
				(NormalEgo)
			)
			(46
				(HandsOff)
				(Ok) ; "O.K."
				(= gEgoState 531)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 141 129 self
				)
			)
			(47
				(gMusic stop:)
				(gEgo
					view: 534
					posn: 142 128
					setLoop: 1
					cel: 0
					setCycle: Fwd
				)
				(= cycles (* 3 (- (NumCels gEgo) 1)))
			)
			(48
				(gEgo setLoop: 0 cel: 0 setCycle: End self)
			)
			(49
				(if (> 2 (++ attempts))
					(= state 46)
				)
				(= seconds 3)
			)
			(50
				(Print 530 89 #at -1 10) ; "Giving it everything you've got, you hurl the rope as hard as you can."
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles (* 3 (- (NumCels gEgo) 1)))
			)
			(51
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(52
				(gGame changeScore: 20)
				(Print 530 90 #at 10 5 #width 290) ; "You did it! You've lassoed that rock on the far side of the canyon."
				(= potState 3)
				(gSoundFX stop:)
				(gMusic play:)
				(HandsOn)
			)
			(53
				(= potState 4)
				(gGame changeScore: 20)
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo
					view: 534
					posn: 141 129
					setPri: 9
					setLoop: 3
					setCycle: Fwd
				)
				(aRope
					view: 530
					setLoop: 0
					cel: 0
					posn: 227 72
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(54
				(aRope stopUpd:)
				(= cycles 10)
			)
			(55
				(Print 530 91 #at 10 5 #width 290) ; "Although your previous experience with knots has been limited to fashion accessories (plus a few weekends spent on yachts in ports around the world serving as deck hand au naturel), you tie the rope to the palm tree as securely as you can."
				(NormalEgo 1)
				(gEgo put: 20 -1) ; Marijuana
				(= gEgoState 0)
			)
			(56
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo view: 534 setLoop: 4 cel: 0 setCycle: End self)
			)
			(57
				(gGame changeScore: 50)
				(Print 530 92 #at 10 5 #width 290) ; "Good idea, Patti! You discreetly remove approximately eight inches from the hem of your dress; just enough so when you climb on your rope you'll have a safety harness for security!"
				(= gNormalEgoView 803)
				((Inv at: 17) view: 31) ; Dress
				(NormalEgo 2)
			)
			(58
				(HandsOff)
				(gEgo posn: 141 129)
				(NormalEgo 0)
				(aRope
					view: 530
					posn: 227 72
					cycleSpeed: 1
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(59
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 27
					register: (Format @string 530 93) ; "Oh, Patti. Without that rope, you'll never make it across the canyon!%"
					next: (Format @string2 530 94) ; "Hey! Hold still, willya?%"
				)
			)
			(60
				(Ok) ; "O.K."
				(HandsOff)
				(= gEgoState 532)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 141 129 self
				)
			)
			(61
				(if (!= gNormalEgoView 803)
					(self cue:)
				else
					(Print 530 95 #at -1 10) ; "Before climbing onto the rope, you slip into your safety harness. Will it be strong enough to hold you?"
					(gEgo
						view: 534
						setLoop: 5
						cel: 0
						cycleSpeed: 1
						setCycle: End self
					)
				)
			)
			(62
				(gEgo
					view: 534
					setLoop: 6
					cel: 0
					posn: 149 107
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(63
				(Print 530 96) ; "You wrap your long, delicate, pianist's fingers and your long, delicate, pianist's legs around your handmade rope. Squeezing your legs tightly together, (an experience wholly unfamiliar to you), you move out over the canyon."
				(gMusic fade:)
				(= seconds 3)
			)
			(64
				(gCurRoom newRoom: 535)
			)
			(65
				(HandsOff)
				(Print (Format @string 530 81 global289) #at -1 10 #dispose) ; "%s"
				(gMusic number: 4 loop: 1 play:)
				(gEgo
					view: 813
					setLoop: (if onOtherSide 1 else 0)
					illegalBits: 0
					ignoreActors:
					setPri: 5
					setStep: 1 8
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(66
				(gEgo setMotion: theJump)
				(theJump y: 300)
			)
			(67
				(cls)
				(if (or (== gEgoState 534) (== gEgoState 535))
					(Print 530 97) ; "Remember, Patti: next time "Just Say NO!""
				else
					(Print 530 98) ; "Way to go, Newton!"
				)
				(if gDebugging
					(NormalEgo)
					(= gEgoState 0)
					(if onOtherSide
						(gEgo posn: 210 77 setStep: 2 1)
					else
						(gEgo posn: 159 158)
					)
				else
					(gGame setScript: (ScriptID 40)) ; DyingScript
					((ScriptID 40) caller: 814 register: (Format @string 530 99)) ; DyingScript, "Who told you the law of gravity had been repealed?%"
				)
			)
		)
	)
)

(instance aRope of Prop
	(properties
		y 1111
		x 999
		view 530
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 7)
	)
)

(instance RopeScript of Script
	(properties)

	(method (cue)
		(aRope stopUpd:)
		(Print 530 100 #at 10 5 #width 290) ; "Patti! Your knot around the palm tree came loose. Now there's no way for you to turn back!"
	)
)

(instance atpTits of PV
	(properties
		y 157
		x 169
		view 532
		loop 3
		priority 7
		signal 16384
	)
)

(instance theJump of Jump
	(properties)

	(method (init)
		(super init: gEgo RoomScript)
		(self yStep: 2)
	)
)

