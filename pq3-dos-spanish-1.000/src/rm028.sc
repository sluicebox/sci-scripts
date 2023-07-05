;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use n882)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm028 0
)

(local
	local0
	[local1 38] = [238 175 173 175 146 162 110 155 106 127 92 132 70 129 46 134 27 130 0 136 0 0 319 0 319 189 281 189 266 160 295 145 317 140 317 95 189 87]
	[local39 46] = [237 171 222 174 195 180 172 189 158 183 179 171 146 159 107 147 106 127 92 132 70 129 46 134 27 130 0 136 0 0 319 0 319 189 281 189 266 160 295 145 317 140 317 95 189 87]
	local85
	local86 = 186
	local87
	[local88 2]
	local90
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance polyNut of Polygon
	(properties
		type PBarredAccess
	)
)

(instance rm028 of PQRoom
	(properties
		picture 28
		south -1
		west 27
	)

	(method (init)
		(LoadMany
			rsVIEW
			291
			292
			294
			298
			299
			302
			301
			1
			8
			283
			293
			314
			295
			296
			297
			300
			303
			304
			305
			306
			307
			309
			310
			311
			312
			313
		)
		(LoadMany
			rsSOUND
			271
			274
			275
			276
			278
			280
			281
			283
			284
			285
			918
			937
			270
			282
			960
		)
		(poly1 points: @local1 size: 19)
		(polyNut points: @local39 size: 23)
		(polyList0 add: poly1)
		(polyList1 add: polyNut)
		(gCurRoom obstacles: polyList0)
		(ScriptID 882)
		(splash init:)
		(river init:)
		(water1 cycleSpeed: 9 setCycle: Fwd init:)
		(water2 cycleSpeed: 9 setCycle: Fwd init:)
		(water3 cycleSpeed: 9 setCycle: Fwd init:)
		(trees init:)
		(sky init:)
		(grass init:)
		(rocks init:)
		(gLongSong number: 270 loop: -1 flags: 1 play:)
		(gEgo view: 1 posn: 10 159 setStep: 3 2 init:)
		(super init:)
		(if (not (OneOf global126 5 6))
			(nut
				view: (if (== global126 1) 314 else 302)
				x: (if (== global126 1) 194 else 186)
				y: (if (== global126 1) 135 else 172)
				setScript: rant1
				init:
			)
			(stompSound setVol: 10 init:)
			(clothes init:)
		)
		(if (not (gCast contains: nut))
			(Print 28 0) ; "Maybe The Bathonians beamed the guy up."
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 0))
		(cond
			(script 0)
			((and (& temp0 $2000) (== global126 0))
				(HandsOff)
				(= global126 1)
				(self setScript: nutScript)
			)
			((& temp0 $1000)
				(HandsOff)
				(if (== global126 1)
					(self setScript: enterWater)
				else
					(self setScript: waterScript)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(polyList0 dispose: release:)
		(polyList1 dispose: release:)
		(if (== global126 4)
			(= global126 5)
		)
		(LoadMany 0 951 882)
		(super dispose:)
	)
)

(instance drawScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global126 3)
					(self dispose:)
				)
				(= cycles 6)
			)
			(1
				(if (== global126 3)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					normal: 0
					view: 8
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(3
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance nutScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(nut
					setScript: 0
					view: 297
					cycleSpeed: 3
					moveSpeed: 3
					ignoreActors: 1
					setCycle: Walk
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(- (gEgo y:) 3)
						self
				)
			)
			(1
				(stompSound stop:)
				(nutMusic play:)
				(iNutLand init:)
				(= save1 1)
				(Say iNutLand 28 1) ; "You! Don't try to stop me! You'll be vaporized if you interfere!"
				(= seconds 8)
			)
			(2
				(iNutLand dispose:)
				(iEgo init:)
				(= save1 1)
				(Say iEgo 28 2) ; "Hey! What are you doing? That's my badge!"
				(= seconds 4)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(nut
					view: 298
					cycleSpeed: 8
					ignoreActors: 0
					cel: 0
					setCycle: End self
				)
				(gEgo normal: 0 view: 299 cel: 0 setCycle: End)
				(soundEffects number: 283 play:)
			)
			(4
				(gEgo normal: 1 view: 1 loop: 3 setCycle: Walk)
				(nut
					view: 297
					cycleSpeed: 3
					moveSpeed: 3
					setCycle: Walk
					setMotion: MoveTo 156 158 self
				)
			)
			(5
				(splash x: 153 y: 111 setCycle: End self)
				(soundEffects number: 284 play:)
			)
			(6
				(nut view: 301 cel: 0 setCycle: End self)
				(stompSound play:)
			)
			(7
				(iNutLand init:)
				(= save1 1)
				(Say iNutLand 28 3) ; "The Bathonians scoff at your badge, lawman! The mothership will squash you like a pimple! This is your last warning!"
				(= seconds 7)
			)
			(8
				(iNutLand dispose:)
				(nut view: 302 cel: 0 cycleSpeed: 8 posn: 166 139 setCycle: Fwd)
				(= cycles 1)
			)
			(9
				(= save1 1)
				(Print 28 4 #at 10 10 #dispose) ; "You can't believe this guy! Deranged men can be real slippery."
				(= seconds 7)
			)
			(10
				(stompSound stop:)
				(nutMusic fade:)
				(nut view: 303 loop: 0 cel: 0 setCycle: CT 13 1 self)
			)
			(11
				(soundEffects number: 274 loop: 1 play:)
				(nut setCycle: End self)
				(= seconds 4)
			)
			(12
				(iNutWater init:)
				(nut view: 304 posn: 194 135 setCycle: Walk)
				(Say iNutWater 28 5) ; "I'm warning you! If you don't leave, I'm gonna have to hurt you! This area must be evacuated!"
				(= seconds 7)
				(= save1 1)
			)
			(13
				(nut view: 314 setScript: rant1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iNutWater dispose:)
				(= cycles 1)
			)
			(14
				(Print 28 6 #at 100 130) ; "Fortunately you're carrying a spare shield. You put it on."
				(= cycles 1)
			)
			(15
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					setMotion: 0
					y: (- (gEgo y:) 12)
					view: 300
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo
					setCycle: Walk
					setLoop: 2
					setMotion: MoveTo (+ (nut x:) 12) (+ (nut y:) 2) self
				)
			)
			(2
				(soundEffects number: 960 play:)
				(= cycles 1)
			)
			(3
				(gEgo hide:)
				(nut
					setScript: 0
					view: 293
					x: (+ (nut x:) 5)
					y: (+ (nut y:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(4
				(= seconds 9)
			)
			(5
				(EgoDead 11) ; "That was a foolish thing to do. He wasn't worth drowning for. Next time try to be more creative."
			)
		)
	)
)

(instance rant1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (== (nut view:) 314)
					(nutWadingMusic play:)
				else
					(stompSound play:)
				)
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(nut loop: (Random 0 1) setCycle: Fwd cycleSpeed: 8)
				(= seconds 4)
				(= state 2)
			)
		)
	)
)

(instance searchClothes of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (- (clothes x:) 19) (clothes y:) self
				)
			)
			(1
				(gEgo
					view: 313
					setLoop: 0
					posn: 185 177
					normal: 0
					setCycle: End self
				)
			)
			(2
				(if (and (not (proc882_2 2)) (not local0))
					(Print 28 7) ; "You search the deranged man's clothes, hoping for something which will lure him out of the water."
					(proc882_0 2)
				else
					(Print 28 8) ; "You find nothing of interest in the clothes."
				)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self)
				(Print 28 9) ; "You find a set of keys and a driver's license."
				(gEgo get: 23) ; license
				((gInventory at: 23) state: 4) ; license
				(SetScore 104 2)
			)
			(4
				(gEgo
					view: 1
					setLoop: -1
					normal: 1
					setStep: 3 2
					setCycle: Walk
				)
				(= cycles 8)
			)
			(5
				(iEgo init:)
				(= save1 1)
				(Say iEgo 28 10) ; "Hey, fella! I think I've got something of yours."
				(= seconds 6)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iEgo dispose:)
				(= cycles 1)
			)
			(7
				(iNutWater init:)
				(= cycles 1)
			)
			(8
				(= save1 1)
				(Say iNutWater 28 11) ; "Leave those keys alone, foolish mortal!"
				(= seconds 5)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iNutWater dispose:)
				(= cycles 1)
			)
			(10
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwKeys of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 160 185 self)
			)
			(1
				(gEgo
					normal: 0
					view: 294
					posn: (+ (gEgo x:) 5) (- (gEgo y:) 5)
					cycleSpeed: 9
					setCycle: CT 4 1 self
				)
			)
			(2
				(soundEffects number: 276 play:)
				(gEgo setCycle: End self)
			)
			(3
				(splash x: 270 y: 121 setCycle: End self)
				(soundEffects number: 284 play:)
			)
			(4
				(= seconds 2)
			)
			(5
				(if register
					(Print 28 12) ; "If nothing else, that helped relieve your aggressions."
					(= cycles 1)
				else
					(= save1 1)
					(iEgo init:)
					(Say iEgo 28 13) ; "There! Now your keys and my badge are neighbors!"
					(= seconds 5)
				)
			)
			(6
				(if (not register)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(iEgo dispose:)
				)
				(gEgo
					normal: 1
					view: 1
					x: (- (gEgo x:) 5)
					y: (+ (gEgo y:) 5)
					setStep: 3 2
					setCycle: Walk
					cycleSpeed: (gEgo moveSpeed:)
				)
				(= cycles 1)
			)
			(7
				(= local0 1)
				(if (not register)
					(SetScore 105 3)
					(nut setScript: goAfterEgo)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance goAfterEgo of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global126 2)
				(= cycles 1)
			)
			(1
				(= cycles 1)
			)
			(2
				(iNutWater init:)
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say iNutWater 28 14) ; "I'll kill you for that - you flat-headed, flat-footed, ignoramous!"
				(= seconds 10)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iNutWater dispose:)
				(= cycles 1)
			)
			(5
				(gTheIconBar enable: 5)
				(User canInput: 1)
				(= cycles 1)
			)
			(6
				(nut setStep: 1 1 view: 304 setMotion: MoveTo 244 154 self)
			)
			(7
				(nut view: 305 loop: 0 cel: 0 setCycle: End self)
			)
			(8
				(nut
					view: 297
					setStep: 3 2
					setCycle: Walk
					cycleSpeed: 3
					moveSpeed: 3
					posn: 244 170
					setMotion: MoveTo (+ (gEgo x:) 9) (- (gEgo y:) 2) self
				)
			)
			(9
				(if (gCurRoom script:)
					(useStickOnNut cue:)
				else
					(gCurRoom setScript: egoGetsIt self)
				)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (not local87) (& (nut onControl: 0) $1000))
			(soundEffects number: 282 play:)
			(= local87 1)
		)
		(super doit:)
	)
)

(instance useStickOnNut of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normal: 0 view: 291 loop: 0 cel: 0)
				(= cycles 1)
			)
			(1
				(soundEffects number: 275 play:)
			)
			(2
				(= global126 4)
				(soundEffects number: 285 play:)
				(gEgo normal: 0 view: 291 loop: 0 cel: 0 setCycle: End)
				(nut view: 307 cel: 0 setCycle: End self)
			)
			(3
				(soundEffects number: 281 play:)
				(= cycles 1)
			)
			(4
				(= save1 1)
				(Print 28 15 #at 10 10 #dispose) ; "Managing to subdue the deranged man with the nightstick, you check for injuries and see that he's more shaken-up than hurt."
				(= seconds 7)
			)
			(5
				(gCurRoom obstacles: polyList1)
				(SetScore 106 5)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(nut setPri: 4 ignoreActors: 1)
				(gEgo normal: 1 view: 1 loop: 0 setCycle: Walk)
				(HandsOn)
				(nut setScript: outColdTimer)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (and (or (== (gEgo cel:) 6) (== (gEgo cel:) 11)) (== state 2))
			(soundEffects number: 285 play:)
		)
		(super doit:)
	)
)

(instance outColdTimer of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(if (== global126 6)
					(self dispose:)
				else
					(HandsOff)
					(= cycles 2)
				)
			)
			(2
				(if (== global126 6)
					(self dispose:)
				else
					(= save1 1)
					(Print 28 16 #at (proc0_20 120 140 140 140 140) 150) ; "Suddenly...the perpetrator regains consciousness."
					(nut
						view: 297
						setPri: -1
						setStep: 3 2
						setCycle: Walk
						cycleSpeed: 3
						moveSpeed: 3
					)
					(= local90 1)
					(= cycles 1)
				)
			)
			(3
				(nut
					setMotion: MoveTo (+ (gEgo x:) 9) (- (gEgo y:) 2) self
				)
			)
			(4
				(self setScript: egoGetsIt)
			)
		)
	)
)

(instance egoGetsIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global126 3)
				(gEgo
					normal: 0
					view: 311
					loop: 0
					x: (- (gEgo x:) 16)
					cel: 0
				)
				(nut view: 296 loop: 0 cel: 0 setCycle: CT 5 1 self)
				(soundEffects number: 280 play:)
			)
			(1
				(nut setCycle: End)
				(gEgo setCycle: End self)
				(soundEffects number: 281 play:)
			)
			(2
				(nut view: 302 loop: 1 setCycle: Fwd)
				(stompSound play:)
				(= seconds 5)
			)
			(3
				(if local90
					(EgoDead 29) ; "Looks like he caught you with YOUR pants down. You shouldn't waste any time when securing a prisoner."
				else
					(EgoDead 12) ; "Don't just stand there while you're being attacked. DO something! It's called self defense."
				)
			)
		)
	)
)

(instance waterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 28 17) ; "This is no time to go swimming."
				(gEgo heading: 180 setMotion: MoveFwd 10 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cuffHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global126 6)
				(nut ignoreActors: 1)
				(gEgo
					setMotion: PolyPath (- (nut x:) 12) (- (nut y:) 4) self
				)
			)
			(1
				(nut hide:)
				(gEgo
					normal: 0
					view: 292
					posn: (+ (gEgo x:) 17) (+ (gEgo y:) 4)
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(2
				(soundEffects number: 918 play:)
				(= cycles 2)
			)
			(3
				(Print 28 18 #at 10 10 #dispose) ; "You cuff the perpetrator while he's down, insuring that he won't have another chance to attack."
				(gEgo
					view: 309
					posn: (+ (gEgo x:) 10) (- (gEgo y:) 8)
					cel: 0
					setCycle: End self
					put: 2 0 ; handcuff
				)
				(SetScore 107 5)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(nut
					ignoreActors: 0
					setPri: -1
					view: 310
					loop: -1
					posn: (- (gEgo x:) 10) (+ (gEgo y:) 2)
					setCycle: Walk
					cycleSpeed: (gEgo moveSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo -20 (gEgo y:) self
					show:
				)
				(gEgo
					normal: 1
					view: 1
					loop: 1
					cycleSpeed: (gEgo moveSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					posn: (+ (gEgo x:) 4) (+ (gEgo y:) 3)
					setCycle: Walk
					setMotion: MoveTo -20 (+ (gEgo y:) 3) self
				)
			)
			(5 0)
			(6
				(SetFlag 5)
				(HandsOn)
				(self dispose:)
				(gCurRoom newRoom: 27)
			)
		)
	)
)

(instance shootHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== global126 1)
						(Face gEgo nut self)
					)
					((and (< (nut x:) 194) (== global126 1))
						(goAfterEgo state: 7)
						(self dispose:)
					)
					(else
						(Face gEgo nut self)
					)
				)
			)
			(1
				(Load rsSOUND 937)
			)
			(2
				(gEgo normal: 0 view: 8 setCycle: End self)
				(nut setCycle: 0)
				(nut setMotion: 0)
			)
			(3
				(soundEffects number: 937 play:)
				(cond
					((== global126 1)
						(nut loop: 1)
					)
					((== global126 0)
						(nut loop: 0)
					)
					((and (== global126 2) (OneOf (nut view:) 304 305))
						(nut loop: 1)
					)
					((== global126 2)
						(nut loop: 0)
					)
				)
				(nut view: 306 cel: 0)
				(= cycles 1)
			)
			(4
				(nut setCycle: End self)
			)
			(5
				(if (== global126 1)
					(nut loop: 2 cycleSpeed: 11 setCycle: Fwd)
				)
				(= cycles 1)
			)
			(6
				(= seconds 4)
			)
			(7
				(EgoDead 13) ; "Shooting a perpetrator whose only threat to you is his mouth and fists is no way to uphold the law. You're suspended from the L.P.D. and the press has a field day discussing 'police brutality'."
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (nut onControl: 0))
		(if (and (== state 1) (not (& temp0 $0080)) (not (& temp0 $1000)))
			(self cue:)
		)
		(super doit:)
	)
)

(instance talkToEgoWater of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(if (not local85)
					(iEgo init:)
					(Say iEgo 28 19) ; "Come out of there! Right now!"
					(= local85 1)
					(= seconds 4)
				else
					(iNutWater init:)
					(switch (Random 0 2)
						(0
							(Say iNutWater 28 20) ; "The Bathonians need our water! They will suck this planet dry!"
						)
						(1
							(Say iNutWater 28 21) ; "If you're here when they come, you'll be crushed like a pimple under the weight of the glorious mothership."
						)
						(2
							(Say iNutWater 28 22) ; "I'm warning you, mortal! You must leave now or DIE."
						)
					)
					(= seconds 8)
					(++ state)
				)
			)
			(1
				(= save1 1)
				(iEgo dispose:)
				(iNutWater init:)
				(Say iNutWater 28 23) ; "You MUST leave now! If you're here when they come, you'll be toast!"
				(= seconds 8)
			)
			(2
				(iNutWater dispose:)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToEgoLand of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= save1 1)
				(iNutLand init:)
				(Say iNutLand 28 24) ; "You there! Leave this place! I've got to secure it before the Bathonians come!"
				(= seconds 7)
			)
			(2
				(= save1 1)
				(Say iNutLand 28 25) ; "Clear out! Get away! The mothership approaches!"
				(= seconds 6)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(iNutLand dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useKeyOnNut of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iNutWater init:)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say iNutWater 28 26) ; "Release those keys, mortal. I am the chosen one, not you!"
				(= seconds 10)
			)
			(2
				(iNutWater dispose:)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clothes of Prop
	(properties
		x 208
		y 175
		view 295
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 28 27) ; "A pile of clothes, probably belonging to the half-naked perpetrator, is sitting by the rocks unattended."
			)
			(3 ; Do
				(if (or (gEgo has: 23) (proc882_2 2)) ; license
					(Print 28 28) ; "There's nothing else of interest in the clothes."
				else
					(HandsOff)
					(self setScript: searchClothes)
				)
			)
			(4 ; Inventory
				(Print 28 29) ; "So,... You're a tailor now!?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nut of Actor
	(properties
		x 195
		y 169
		view 302
		cycleSpeed 7
		moveSpeed 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 28 30) ; "The man's clearly in a deranged state of mind - though whether because of drug use or some mental instability is unclear."
			)
			(5 ; Talk
				(HandsOff)
				(cond
					((== global126 1)
						(gCurRoom setScript: talkToEgoWater)
					)
					((== (nut script:) rant1)
						(gCurRoom setScript: talkToEgoLand)
					)
					(else
						(HandsOn)
						(Print 28 31) ; "The man isn't listening to you."
					)
				)
			)
			(3 ; Do
				(switch global126
					(1
						(Print 28 32) ; "You can't subdue him from here."
					)
					(2
						(Print 28 33) ; "What are you going to do, kiss him?"
					)
					(4
						(Print 28 34) ; "He's already down. Police brutality wasn't part of your training."
					)
					(else
						(gEgo setMotion: PolyPath 139 169)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(3 ; theKeys
						(if (proc882_2 2)
							(HandsOff)
							(gCurRoom setScript: useKeyOnNut)
						else
							(super doVerb: theVerb invItem)
						)
					)
					(1 ; gun
						(if (== (nut script:) rant1)
							(nut setScript: 0)
						)
						(cond
							((== global126 4)
								(Print 28 35) ; "You aren't going to shoot an unconscious man in the back are you?"
							)
							((< (gEgo distanceTo: nut) 30)
								(HandsOff)
								(gEgo setScript: drawScript)
							)
							(else
								(HandsOff)
								(gCurRoom setScript: shootHim)
							)
						)
					)
					(2 ; handcuff
						(switch global126
							(4
								(HandsOff)
								(gCurRoom setScript: cuffHim)
							)
							(2
								(Print 28 36) ; "You need to subdue him first."
							)
							(3
								(Print 28 37) ; "Too late now..."
							)
							(else
								(Print 28 38) ; "You are not close enough to handcuff him."
							)
						)
					)
					(16 ; nightStick
						(switch global126
							(1
								(Print 28 32) ; "You can't subdue him from here."
							)
							(2
								(HandsOff)
								(gCurRoom setScript: useStickOnNut)
							)
							(3
								(Print 28 37) ; "Too late now..."
							)
							(4
								(Print 28 39) ; "He's already down. Police brutality wasn't part of your training."
							)
							(else
								(Print 28 40) ; "Using a nightstick on someone who hasn't threatened you is against the law."
							)
						)
					)
					(19 ; wallet
						(Print 28 41) ; "That guy wouldn't know or care if you were President of the United States."
					)
					(else
						(Print 28 42) ; "The lunatic is not impressed."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) local86 0)) 0)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(if (== (stompSound number:) 282)
			(stompSound setVol: (+ (* (- 100 (/ temp0 3)) 2) 30))
		)
	)
)

(instance river of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 28 43) ; "The river's considerable undertow churns the waters into a muddy green."
			)
			(3 ; Do
				(gEgo setMotion: PolyPath 241 172)
			)
			(5 ; Talk
				(Print 28 44) ; "The water babbles back."
			)
			(4 ; Inventory
				(switch invItem
					(3 ; theKeys
						(if (proc882_2 2)
							(Print 28 45) ; "Calling on your old softball arm, you haul back and throw the keys as far as you can into the river."
							(proc882_1 2)
							(if (gCast contains: nut)
								(HandsOff)
								(gCurRoom setScript: throwKeys 0 0)
							else
								(HandsOff)
								(gCurRoom setScript: throwKeys 0 1)
							)
						else
							(super doVerb: theVerb invItem)
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

(instance water1 of Prop
	(properties
		x 200
		y 103
		view 283
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(river doVerb: theVerb invItem)
	)
)

(instance water2 of Prop
	(properties
		x 252
		y 105
		view 283
		loop 1
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(river doVerb: theVerb invItem)
	)
)

(instance water3 of Prop
	(properties
		x 288
		y 112
		view 283
		loop 2
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(river doVerb: theVerb invItem)
	)
)

(instance trees of Feature
	(properties
		x 109
		y 40
		description {the trees}
		onMeCheck 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 28 46) ; "The graceful willow trees make Aspen Falls the prettiest park for miles around."
			)
			(3 ; Do
				(Print 28 47) ; "You don't have time to climb trees."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sky of Feature
	(properties
		x 215
		y 25
		description {the sky}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 28 48) ; "The azure summer sky is accented by wispy clouds."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grass of Feature
	(properties
		x 130
		y 122
		description {the grass}
		onMeCheck 5280
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 28 49) ; "The grass stays lush and green on the banks of the river."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rocks of Feature
	(properties
		x 167
		y 147
		description {the rocks}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 28 50) ; "A few large rocks mark a favorite spot for wading."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance splash of Prop
	(properties
		x 248
		y 128
		view 313
		loop 1
		cel 5
		cycleSpeed 9
	)
)

(instance iEgo of View
	(properties
		x 53
		y 122
		view 25
		priority 14
		signal 16
	)

	(method (init)
		(iEgoMouth x: (iEgo x:) y: (iEgo y:) setCycle: RandCycle init:)
		(iEgoEyes x: (iEgo x:) y: (iEgo y:) init: setScript: egoEyesBlink)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
	)
)

(instance iEgoEyes of Prop
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
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance iNutLand of Prop
	(properties
		x 59
		y 47
		description {Nut}
		view 312
		priority 13
		signal 16
	)

	(method (init)
		(iNutMouth x: (iNutLand x:) y: (iNutLand y:) setCycle: RandCycle init:)
		(iNutEyes x: (iNutLand x:) y: (iNutLand y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(iNutMouth dispose:)
		(iNutEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iNutWater of Prop
	(properties
		x 59
		y 47
		view 312
		cel 1
		priority 13
		signal 16400
	)

	(method (init)
		(iNutMouth
			x: (iNutWater x:)
			y: (iNutWater y:)
			setCycle: RandCycle
			init:
		)
		(iNutEyes x: (iNutWater x:) y: (iNutWater y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(iNutMouth dispose:)
		(iNutEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iNutMouth of Actor
	(properties
		view 312
		loop 1
		priority 14
		signal 16400
		cycleSpeed 8
	)
)

(instance iNutEyes of Actor
	(properties
		view 312
		loop 2
		priority 14
		signal 16400
		cycleSpeed 9
	)
)

(instance soundEffects of Sound
	(properties)
)

(instance nutMusic of Sound
	(properties
		flags 1
		number 271
	)
)

(instance nutWadingMusic of Sound
	(properties
		flags 1
		number 278
		loop -1
	)
)

(instance stompSound of Sound
	(properties
		number 282
		vol 5
		loop -1
	)
)

(instance polyList0 of List
	(properties)
)

(instance polyList1 of List
	(properties)
)

