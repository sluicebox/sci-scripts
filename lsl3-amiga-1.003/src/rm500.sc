;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use System)

(public
	rm500 0
	RedrawMaze 1
	BitSet 2
)

(local
	[local0 66]
	[local66 22]
	[local88 20] = [-16564 5177 19666 27846 18175 19476 14668 -11668 -14778 -2049 -12039 -6221 -28275 -28200 -29441 -24077 -12441 8987 9137 6655]
	local108 = 500
	local109
	local110
	local111
)

(procedure (RedrawMaze &tmp i)
	(gCurRoom drawPic: local108)
	(if (BitSet (+ 0 local109))
		(gCurRoom overlay: (+ local108 4))
	)
	(if (BitSet (+ 80 local109))
		(gCurRoom overlay: (+ local108 2))
	)
	(if (BitSet (+ 240 local109))
		(gCurRoom overlay: (+ local108 3))
	)
	(if (BitSet (+ 160 local109))
		(gCurRoom overlay: (+ local108 1))
	)
)

(procedure (BitSet index)
	(return
		(if (& [local88 (/ index 16)] (>> $8000 (mod index 16))) 1 else 0)
	)
)

(instance rm500 of Rm
	(properties
		picture 500
		horizon 22
	)

	(method (init &tmp i)
		(for ((= i 500)) (< i 510) ((++ i))
			(Load rsPIC i)
		)
		(Load rsVIEW 800)
		(Load rsVIEW 501)
		(Load rsVIEW 502)
		(Load rsVIEW 503)
		(if (gEgo has: 13) ; Bottle_of_Wine
			(Load rsVIEW ((Inv at: 13) view:)) ; Bottle_of_Wine
		)
		(Load rsSOUND 501)
		(Load rsSOUND 502)
		(Load rsSOUND 503)
		(super init:)
		(gMusic number: 500 loop: gBgMusicLoops play:)
		(if (not gEgoIsPatti)
			(= gEgoIsPatti 1)
			(= gNormalEgoView 800)
		)
		(self setScript: RoomScript)
		(if (== gPrevRoomNum 510)
			(gEgo posn: 177 26)
			(= local109 1)
		else
			(gEgo posn: (Random 130 234) 188)
			(= local109 68)
		)
		(RedrawMaze)
		(NormalEgo)
		(gEgo baseSetter: SteadyBase setCycle: SlowWalk init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (gEgo edgeHit:)
			(= local111 (gEgo edgeHit:))
			(gEgo edgeHit: 0 illegalBits: 0)
			(gGame setCursor: gWaitCursor 1)
			(HandsOff)
			(++ local110)
			(self changeState: 0)
			(cond
				((< local110 8)
					(gEgo view: 800 moveSpeed: 0)
				)
				((< local110 14)
					(gEgo view: 501 moveSpeed: 0)
					(if (!= 501 (gMusic number:))
						(gMusic fade:)
					)
				)
				((< local110 17)
					(gEgo view: 502 moveSpeed: 1)
					(if (!= 502 (gMusic number:))
						(gMusic fade:)
					)
				)
				((< local110 18)
					(gEgo view: 503 moveSpeed: 2)
					(if (!= 503 (gMusic number:))
						(gMusic fade:)
					)
				)
				(else
					(gEgo view: 503 moveSpeed: 3)
					(self changeState: 2)
				)
			)
			(switch local111
				(1
					(if (== local109 1)
						(gMusic fade:)
						(if (not (TestFlag 37))
							(gGame changeScore: 100)
							(Print 500 0) ; "YOU DID IT!"
							(Print 500 1) ; "As you stumble out of the bamboo forest, you find yourself beside a beautiful stream."
						)
						(gCurRoom newRoom: 510)
						(return)
					else
						(-= local109 8)
					)
				)
				(3
					(if (== local109 68)
						(gCurRoom newRoom: 245)
						(return)
					else
						(+= local109 8)
					)
				)
				(2
					(++ local109)
				)
				(4
					(-- local109)
				)
			)
			(if (== local108 505)
				(= local108 500)
				(switch local111
					(1
						(gEgo posn: (Random 130 234) 187)
					)
					(3
						(gEgo posn: 177 26)
					)
					(2
						(gEgo posn: 1 74)
					)
					(else
						(gEgo posn: 317 74)
					)
				)
			else
				(= local108 505)
				(switch local111
					(1
						(gEgo posn: (Random 80 163) 187)
					)
					(3
						(gEgo posn: 188 26)
					)
					(2
						(gEgo posn: 1 83)
					)
					(else
						(gEgo posn: 314 128)
					)
				)
			)
			(RedrawMaze)
			(Animate (gCast elements:) 0)
			(gEgo illegalBits: -32768)
			(HandsOn)
			(gGame setCursor: gNormalCursor (HaveMouse))
			(return)
		)
		(if (== (GameIsRestarting) 2)
			(RedrawMaze)
			(Animate (gCast elements:) 0)
		)
	)

	(method (handleEvent event &tmp i)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'get/bamboo')
				(Print 500 2) ; "You try your best to pull the nearest bamboo stalk out of the ground, but you are unable to budge it."
			)
			((Said 'climb/bamboo')
				(Print 500 3) ; "It would never hold you."
			)
			((Said 'hit/bamboo')
				(Print 500 4) ; "You ARE frustrated, aren't you, Patti?"
			)
			((Said 'nightstand,(get,nightstand<up)')
				(Print 500 5) ; "You simply can not."
			)
			(
				(or
					(Said 'sip/water')
					(Said 'get/drink<1')
					(Said 'use,drink,drain/water,beer,bottle')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (gEgo has: 13)) ; Bottle_of_Wine
						(DontHave) ; "You don't have it."
					)
					((== ((Inv at: 13) view:) 28) ; Bottle_of_Wine
						(Print 500 6 #icon 28 0 0) ; "Either this wine is VERY dry, or your bottle is empty!"
					)
					(else
						(Ok) ; "O.K."
						(gGame changeScore: 20)
						(= local110 0)
						(gMusic number: 500 loop: gBgMusicLoops play:)
						(Print 500 7 #icon 29 0 0) ; "You briefly consider a conservative rationing plan for your precious water. Oh, what the hell! Instead, you chug-a-lug the entire liter! Boy! You didn't realize how thirsty you really were!"
						(Print 500 8) ; "Blindly celebrating your thirst-crazed delirium, you throw the now-empty wine bottle far out into the bamboo thicket in protest of bottle-bill laws everywhere!"
						(PutInRoom 13)
						(NormalEgo)
						(gEgo baseSetter: SteadyBase setCycle: SlowWalk)
						(self changeState: 0)
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '[/area]')
						(Print 500 9) ; "You see lots of bamboo everywhere."
						(Print 500 10 #at -1 144) ; "(Are you sure you know what you're doing here)"
					)
					((Said '/bamboo')
						(Print 500 11) ; "You carefully examine the bamboo stalk closest to you. It looks exactly like every other bamboo stalk you've ever seen."
						(Print (Format @local0 500 12 gBambooCount) #at -1 144) ; "Which is exactly %d."
						(++ gBambooCount)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(cond
					(
						(and
							(>= local110 8)
							(<= local110 13)
							(!= 501 (gMusic number:))
						)
						(gMusic number: 501 loop: gBgMusicLoops play:)
					)
					(
						(and
							(>= local110 14)
							(<= local110 16)
							(!= 502 (gMusic number:))
						)
						(gMusic number: 502 loop: gBgMusicLoops play:)
					)
					(
						(and
							(<= local110 18)
							(>= local110 17)
							(!= 503 (gMusic number:))
						)
						(gMusic number: 503 loop: gBgMusicLoops play:)
					)
				)
				(cond
					((== local110 4)
						(Print 500 13) ; ""Boy, could I use a good belt about now!" you think to yourself."
					)
					((== local110 8)
						(Print 500 14) ; "You think to yourself, "I'm sweating worse than a jazz clarinetist in a cowboy bar!""
					)
					((== local110 12)
						(Print 500 15) ; "Like, there wouldn't be a nice little cocktail lounge hidden out in this gawdfersakin' mess, would there?"
					)
					((== local110 16)
						(Print 500 16) ; "Why is everything here shaped like a swizzle stick?"
						(Print 500 17) ; "Why am I crawling around like this?"
						(Print 500 18) ; "Why am I talking to myself?"
						(Print 500 19) ; "I'M DELIRIOUS!!!"
					)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(Print 500 20) ; "You are feeling VERY tired and thirsty."
				(= seconds 3)
			)
			(4
				(Print 500 21) ; "You have almost no energy left."
				(= seconds 3)
			)
			(5
				(HandsOff)
				(Print 500 22) ; "As you take leave of your withered, dehydrated body you wonder, "Is this what it's like to play Cleveland?""
				(gEgo
					illegalBits: 0
					setMotion: 0
					view: 504
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(6
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 505
					register: (Format @local0 500 23) ; "Patti, you really must start packing more sensibly when you take these little outings of yours!"
					next: (Format @local66 500 24) ; "Bamboo-zled"
				)
			)
		)
	)
)

(instance SteadyBase of Code
	(properties)

	(method (doit)
		(gEgo brBottom: (+ (gEgo y:) 1))
		(gEgo brTop: (- (gEgo brBottom:) 2))
		(gEgo brLeft: (- (gEgo x:) 10))
		(gEgo brRight: (+ (gEgo x:) 10))
	)
)

(class SlowWalk of Fwd
	(properties)

	(method (doit)
		(if
			(or
				(!= (client x:) (client xLast:))
				(!= (client y:) (client yLast:))
			)
			(super doit:)
		)
	)
)

