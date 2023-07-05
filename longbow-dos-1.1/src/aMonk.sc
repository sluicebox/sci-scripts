;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	aMonk 0
	monkScript 1
)

(local
	local0
	local1
	[local2 17] = [-1 {Abbey Monk} 26 0 0 0 0 0 0 0 4 6 2 7 5 1 3]
	local19
	local20
	local21
	[local22 10] = [1028 28 1 2 1 2 1 2 1 0]
	[local32 5] = [1028 35 1 2 0]
	[local37 4] = [1028 37 1 0]
	[local41 6] = [1028 1 2 1 2 0]
	[local47 5] = [1028 4 2 1 0]
	[local52 5] = [1028 6 2 1 0]
	[local57 7] = [1028 8 1 2 1 2 0]
	[local64 5] = [1028 12 1 2 0]
	[local69 5] = [1028 14 1 2 0]
	[local74 11] = [1028 16 2 1 1 2 1 2 1 2 0]
	[local85 4] = [1028 24 1 0]
	[local89 6] = [1028 25 2 1 2 0]
	[local95 4] = [1028 51 2 0]
	[local99 7] = [1028 43 2 2 1 2 0]
	[local106 5] = [1028 47 1 2 0]
	[local111 5] = [1028 49 1 2 0]
	[local116 4] = [1028 42 1 0]
	[local120 5] = [1028 38 1 2 0]
	[local125 5] = [1028 40 1 1 0]
	[local130 5] = [1028 52 2 1 0]
	[local135 8] = [1028 54 2 1 2 1 2 0]
	[local143 6] = [1028 61 1 1 2 0]
	[local149 4] = [1028 64 1 0]
	[local153 4] = [1028 65 1 0]
	[local157 6] = [1028 66 1 1 2 0]
)

(instance aMonk of Actor
	(properties
		description {the Abbey Monk}
		view 129
		signal 8192
	)

	(method (init)
		(LoadMany rsSOUND 153 152)
		(gSFX number: 125 loop: -1 play:)
		(monkPoly init:)
		(if (== gDay 5)
			(SetFlag 133)
		else
			(SetFlag 134)
		)
		(super init:)
	)

	(method (doit)
		(if (and (monkPoly onMe: gEgo) (not local19) (not (gEgo script:)))
			(= local19 1)
			(self setScript: assumeThePosition)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1028 0) ; "He's as fat and soft as most of these Monks are from St. Mary's Abbey. They lead too pampered a life."
			)
			(5 ; Talk
				(if (not (Wat charFirstTalk:))
					(Wat charFirstTalk: 1)
					(gEgo setScript: talkTalkScript)
				else
					(Converse @local89 2 10) ; "Don't harm me, I beg you. I'm only a poor, helpless monk."
				)
			)
			(10 ; Longbow
				(gEgo setScript: drawBow)
			)
			(4 ; Inventory
				(if (OneOf invItem 0 2 14 18 10 4 1 17 16) ; bucks, halfHeart, amethyst, waterRing, fireRing, net, horn, handScroll, fulkScroll
					(if
						(&
							local1
							(switch invItem
								(2 1) ; halfHeart
								(14 2) ; amethyst
								(18 4) ; waterRing
								(10 8) ; fireRing
								(4 16) ; net
								(1 32) ; horn
								(17 64) ; handScroll
								(16 128) ; fulkScroll
							)
						)
						(Say 1028 59) ; "I need not offer that to the monk again."
					else
						(|=
							local1
							(switch invItem
								(2 1) ; halfHeart
								(14 2) ; amethyst
								(18 4) ; waterRing
								(10 8) ; fireRing
								(4 16) ; net
								(1 32) ; horn
								(17 64) ; handScroll
								(16 128) ; fulkScroll
							)
						)
						(gEgo setScript: approachMonk 0 invItem)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(3 ; Do
				(= local19 1)
				(gEgo setScript: approachMonk 0 999)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSFX fade: 0 30 8 1)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(Wat weMeetAgain: 1)
		(if (gFeatures contains: monkPoly)
			(monkPoly dispose:)
		)
		(SetFlag 169)
		(super dispose:)
		(self delete:)
		(DisposeScript 28)
	)
)

(instance tuckie of Prop
	(properties
		x 187
		y 83
		view 168
		loop 1
		priority 4
		signal 16
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
				(Say 1028 60 1) ; "I hardly need my men to deal with this cowardly fellow."
				1
			)
		)
	)
)

(instance monkScript of TScript
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (== (Wat travelDir:) 3)
					(= temp0 235)
					(= temp1 50)
					(= temp2 205)
					(= temp3 70)
					(gCurRoom horizon: 30)
				else
					(= temp0 85)
					(= temp1 160)
					(= temp2 135)
					(= temp3 125)
				)
				(HandsOff)
				(Wat setScript: 0)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(if (not (gCast contains: aMonk))
						(aMonk init:)
					)
					(aMonk
						posn: temp0 temp1
						setLoop: (if (== (Wat travelDir:) 3) 0 else 1)
						setCycle: Walk
						setMotion: MoveTo temp2 temp3 self
					)
				)
			)
			(1
				(aMonk ignoreActors: 1 setLoop: (+ (aMonk loop:) 2) setCel: 0)
				(gCurRoom
					addObstacle:
						(if (== (Wat travelDir:) 3)
							((Polygon new:)
								type: PBarredAccess
								init: 230 56 230 79 176 79 176 56
								yourself:
							)
						else
							((Polygon new:)
								type: PBarredAccess
								init: 110 113 164 113 164 135 110 135
								yourself:
							)
						)
				)
				(NormalEgo)
				(= ticks 18)
			)
			(2
				(Converse @local22 3 10 self) ; "Top of the day to you, Brother."
			)
			(3
				(HandsOn)
				(gEgo actions: egoActions)
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gCurRoom
					addObstacle:
						(if (== (Wat travelDir:) 3)
							((Polygon new:)
								type: PBarredAccess
								init: 230 56 230 79 176 79 176 56
								yourself:
							)
						else
							((Polygon new:)
								type: PBarredAccess
								init: 110 113 164 113 164 135 110 135
								yourself:
							)
						)
				)
				(Converse 2 @local32 3 0 10 3 self) ; "Well, here we are again, sharing the road."
			)
			(2
				(Converse 1 @local37 1 0 self) ; "I trow, if this is how you answer to a mere hello, I shudder to think what a true threat would do to you."
			)
			(3
				(HandsOn)
				(gEgo actions: egoActions)
				(self dispose:)
			)
		)
	)
)

(instance approachMonk of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(SetIcon 0)
				(HandsOff)
				(switch register
					(0
						(if (> (gEgo distanceTo: aMonk) 25)
							(if (== (Wat travelDir:) 1)
								(gEgo
									setMotion:
										PolyPath
										(+ (aMonk x:) 17)
										(- (aMonk y:) 5)
										self
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(- (aMonk x:) 17)
										(+ (aMonk y:) 5)
										self
								)
							)
						else
							(self cue:)
						)
					)
					(999
						(gEgo setMotion: PChase aMonk 50 self)
					)
					(else
						(gEgo setMotion: PChase aMonk 40 self)
					)
				)
			)
			(1
				(if (== register 999)
					(client setScript: bowAndScrape)
				else
					(Face gEgo aMonk self)
				)
			)
			(2
				(= ticks 12)
			)
			(3
				(if (OneOf register 2 14 10 18 4)
					(Converse 1 @local95 10 3 self) ; "Your p-pardon, but I think I'd best not accept such a gift from an outlaw, lest you think I'm then in your debt."
				else
					(switch register
						(1
							(Converse 1 @local116 10 3 self) ; "Ahm...very nice. Nice horn. I...uhm...don't think I should touch it."
						)
						(17
							(Converse @local130 1 10 self) ; "Ah, em, very interesting. I'm sure you want to keep it."
						)
						(16
							(Converse @local135 1 10 self) ; "My, what, ummmm, clever verses. Did you write these?"
						)
						(0
							(cond
								(local20
									(Converse @local111 1 10 self) ; "I bid you to reconsider the value of your robe."
								)
								((= temp0 (gMoney doit:))
									(= local20 1)
									(client setScript: talkBuckScript)
								)
								(else
									(self cue:)
								)
							)
						)
					)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drawBow of Script
	(properties)

	(method (dispose)
		(shootSound stop: dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(SetIcon 0)
				(HandsOff)
				(LoadMany rsVIEW 4 5)
				(switch (Wat travelDir:)
					(1
						(if (> (gEgo y:) (aMonk y:))
							(if (< (gEgo x:) (aMonk x:))
								(gEgo
									setMotion:
										PolyPath
										(- (aMonk x:) 50)
										(aMonk y:)
										self
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(+ (aMonk x:) 50)
										(aMonk y:)
										self
								)
							)
						else
							(self cue:)
						)
					)
					(3
						(if (< (gEgo y:) (aMonk y:))
							(if (< (gEgo x:) (aMonk x:))
								(gEgo
									setMotion:
										PolyPath
										(- (aMonk x:) 50)
										(aMonk y:)
										self
								)
							else
								(gEgo
									setMotion:
										PolyPath
										(+ (aMonk x:) 50)
										(aMonk y:)
										self
								)
							)
						else
							(self cue:)
						)
					)
				)
			)
			(1
				(Face gEgo aMonk self)
			)
			(2
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(3
				(shootSound play:)
				(if (not local19)
					(aMonk setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(Converse @local120 1 10 self) ; "I'll have your robe. Now!"
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(Converse 1 @local125 1 0 self) ; "I trow, monk, threatening you with a bow is like swatting a fly with a catapult!"
			)
			(7
				(shootSound stop:)
				(gSFX number: 127 loop: -1 play:)
				(= gDisguiseNum 5) ; abbey monk
				(SetFlag 55)
				(if (== gDay 5)
					(SetFlag 25)
				)
				(= gBlowCount 0)
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(NormalEgo)
				((gCurRoom obstacles:) eachElementDo: #dispose release:)
				(= temp0 (PicNotValid))
				(PicNotValid 1)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32762)
				(Animate (gCast elements:) 0)
				(PicNotValid temp0)
				(= ticks 60)
			)
			(8
				(gCurRoom drawPic: 150 -32761)
				(self setScript: whippingBoy self)
			)
			(9
				(tuckie dispose:)
				(gCast eachElementDo: #hide)
				(NormalEgo)
				(gEgo loop: 5 cel: 0 posn: 160 90)
				(gEgoHead z: 38 posn: 160 90)
				(gCurRoom drawPic: 803 -32762)
				(= ticks 24)
			)
			(10
				(proc125_2)
				(gCurRoom drawPic: 120 -32761)
				(proc121_0 1)
				(gEgo show:)
				(gEgoHead show:)
				(SetIcon 0)
				(= cycles 3)
			)
			(11
				(HandsOn)
				(SetScore -75)
				(self dispose:)
				(aMonk dispose:)
			)
		)
	)
)

(instance bowAndScrape of TScript
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (aMonk cel:)
					(self cue:)
				else
					(aMonk setCycle: End self)
				)
			)
			(1
				(Converse @local41 1 10 self 0) ; "Don't hurt me! I beg you, don't hurt me."
			)
			(2
				(Converse @local57 3 10 self 0) ; "Come now, there's no need for such fear."
			)
			(3
				(Converse @local64 2 10 self 0) ; "Is that a problem?"
			)
			(4
				(Converse @local69 3 10 self 1) ; "That's better. A visit to my camp will refresh you. You can learn the value of good, honest labor."
			)
			(5
				(gSFX number: 128 loop: -1 play:)
				(= gDisguiseNum 5) ; abbey monk
				(SetFlag 55)
				(if (== gDay 5)
					(SetFlag 25)
				)
				(NormalEgo)
				(gCast eachElementDo: #hide)
				((gCurRoom obstacles:) eachElementDo: #dispose release:)
				(gCurRoom drawPic: 150 -32761)
				(self setScript: whippingBoy self)
			)
			(6
				(tuckie dispose:)
				(gEgo loop: 5 cel: 0 posn: 160 90)
				(gEgoHead z: 38 posn: 160 90)
				(NormalEgo)
				(= temp0 (PicNotValid))
				(PicNotValid 1)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32762)
				(Animate (gCast elements:) 0)
				(PicNotValid temp0)
				(= ticks 24)
			)
			(7
				(gCurRoom drawPic: 120 -32761)
				(= gBlowCount 0)
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(NormalEgo)
				(gEgo show:)
				(proc121_0 1)
				(proc125_2)
				(SetIcon 0)
				(= cycles 3)
			)
			(8
				(SetScore 75)
				(HandsOn)
				(self dispose:)
				(aMonk dispose:)
			)
		)
	)
)

(instance talkTalkScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local74 1 10 self 0) ; "You w-wouldn't harm a man of the cloth, would you, sir?"
			)
			(1
				(Converse @local85 2 10) ; "I'll think about it."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkBuckScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local99 1 10 self 0) ; "Oh, God bless you, that's generous of you. Thank you very much."
			)
			(1
				(if (and (monkPoly onMe: gEgo) (not local19))
					(Converse @local106 2 10 self 0) ; "I grow unhappy with you, Monk."
				else
					(Converse @local106 2 10 self) ; "I grow unhappy with you, Monk."
				)
			)
			(2
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance monkPoly of Feature
	(properties)

	(method (init)
		(if (== (Wat travelDir:) 3)
			((= onMeCheck (Polygon new:))
				type: PTotalAccess
				init: 188 87 117 60 180 37 261 66
				yourself:
			)
		else
			((= onMeCheck (Polygon new:))
				type: PTotalAccess
				init: 169 92 209 123 195 147 70 147 36 103
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance assumeThePosition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(client setCycle: End self)
			)
			(1
				(if (> (gEgo distanceTo: aMonk) 40)
					(Converse @local47 2 10 self) ; "Please don't hurt me, I beg you!"
				else
					(Converse @local52 2 10 self) ; "Please don't hurt me, I beg you!"
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance whippingBoy of Script
	(properties)

	(method (doit)
		(if (and local0 (== (tuckie cel:) 4))
			(spankSound play:)
			(aMonk loop: 6 cel: 0 setCycle: End)
			(= local0 0)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(spankSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(aMonk loop: 6 cel: (aMonk lastCel:) x: 155 y: 85 show:)
				(tuckie init: setCycle: End self)
			)
			(1
				(aMonk loop: 5 cel: 0 setScript: chopChop self)
			)
			(2
				(= local0 1)
				(tuckie cel: 1)
				(tuckie setCycle: End self)
			)
			(3
				(Converse 2 @local143 @local2 2 15 3 self) ; "Have mercy! Oh, good Friar, how can you consort with these thieves and rogues?"
			)
			(4
				(= ticks 60)
			)
			(5
				(aMonk loop: 5 cel: 0 setScript: chopChop self)
			)
			(6
				(gEgo
					loop: 1
					posn: 317 137
					show:
					setMotion: MoveTo 240 120 self
				)
			)
			(7
				(gEgo setHeading: 315 self)
			)
			(8
				(= ticks 30)
			)
			(9
				(= local0 1)
				(tuckie setCel: 1 setCycle: End self)
			)
			(10
				(Converse 1 @local149 15 3 self) ; "Robin! Why, you make a fine figure of a monk in that robe."
			)
			(11
				(= local0 1)
				(Converse 1 @local153 9 2 self) ; "Bless you, my son. Take good care of our guest. I'm off to Watling Street."
			)
			(12
				(tuckie setCycle: End self)
			)
			(13
				(aMonk loop: 5 cel: 0 setScript: chopChop self)
			)
			(14
				(= ticks 120)
			)
			(15
				(= local0 1)
				(tuckie setCel: 1 setCycle: End self)
			)
			(16
				(= local0 1)
				(Converse 2 @local157 15 3 @local2 1 self) ; "When he's finished with this, I'll take him out to gather more firewood to chop."
			)
			(17
				(tuckie setCycle: End self)
			)
			(18
				(aMonk loop: 5 cel: 0 setScript: chopChop self)
			)
			(19
				(gEgo setMotion: MoveTo 123 146 self)
			)
			(20
				(aMonk setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance chopChop of Script
	(properties)

	(method (dispose)
		(chopSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (== (spankSound prevSignal:) -1)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(chopSound play:)
				(= ticks (* 10 (Random 7 12)))
			)
			(4
				(client cel: 0)
				(= ticks 6)
			)
			(5
				(if (== (spankSound prevSignal:) -1)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(6
				(client setCycle: End self)
			)
			(7
				(chopSound play:)
				(= ticks (* 10 (Random 12 19)))
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 900
		loop -1
	)
)

(instance chopSound of Sound
	(properties
		flags 1
		number 152
	)
)

(instance spankSound of Sound
	(properties
		flags 1
		number 153
	)
)

