;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PAvoider)
(use Talker)
(use PChase)
(use Polygon)
(use Feature)
(use LoadMany)
(use Grooper)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm46 0
)

(local
	local0
	local1
	local2
)

(instance rm46 of SQRoom
	(properties
		lookStr {This is the pickup area for Droids-B-Us.}
		picture 46
		east 47
		south 41
		west 45
	)

	(method (init)
		(switch gPrevRoomNum
			(south
				(= style 10)
			)
			(east
				(gEgo x: 300)
				(= style 11)
				(HandsOn)
			)
			(west
				(gEgo x: 20)
				(= style 12)
				(HandsOn)
			)
			(else
				(= style 8)
				(cond
					((IsFlag 32)
						(= local0 1)
						(self setScript: complexRobot)
					)
					((IsFlag 44)
						(LoadMany rsSOUND 411 630)
						(self setScript: rightRobot 0 1)
					)
					((and (IsFlag 25) (not (IsFlag 33)))
						(self setScript: rightRobot)
					)
					(else
						(HandsOn)
					)
				)
				(if local0
					(self
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 319 179 289 176 260 170 230 161 187 146 173 140 173 150 139 152 135 145 119 145 106 140 86 140 83 126 102 116 94 110 84 107 87 97 0 97 0 0 319 0
								yourself:
							)
					)
				else
					(self
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 319 179 289 176 260 170 230 161 194 142 173 140 173 150 133 150 130 134 163 133 129 126 108 126 100 119 95 107 84 107 87 97 0 97 0 0 319 0
								yourself:
							)
					)
				)
			)
		)
		(if (!= style 8)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 179 289 176 260 170 230 161 194 142 173 140 173 150 133 150 123 130 108 126 100 119 95 107 84 107 87 97 0 97 0 0 319 0
						yourself:
					)
			)
		)
		(self setRegions: 702) ; ulenceRegion
		(gEgo init:)
		(super init:)
		(if local0
			(gAddToPics add: box2 box3 eachElementDo: #init doit:)
			(box1 init: stopUpd:)
		)
		(radar init: setCycle: Fwd)
		(robbie init: stopUpd:)
		(store init:)
		(pickupArea init:)
		(pickupSign init:)
		(giraffe init:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 flags: 0)
		(super newRoom: newRoomNumber)
	)
)

(instance complexRobot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 331 186 setMotion: MoveTo 111 162 self)
			)
			(1
				(gEgo setMotion: MoveTo 113 150 self)
			)
			(2
				(gEgo setMotion: MoveTo 126 147 self)
			)
			(3
				(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				(robbie
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 158 145 self
				)
			)
			(4
				(robbie setLoop: 1 cel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(5
				(robbie stopUpd:)
				(robbieT
					init:
						robBust
						topGear
						robMouth
						{"Here's your incredibly complex robot, sir.__I sprained my thermodiodinal-tricycler carrying it out here for you.__I hope you're satisfied."}
						0
						0
						0
						self
				)
			)
			(6
				(robbieT
					say:
						{"And I hope you're smarter than you look, or you'll never be able to put it together.__How depressing."}
						0
						0
						1
						self
				)
			)
			(7
				(gLongSong2 stop:)
				(ClearFlag 32)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance blowUpBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 46 0) ; "Well, okay. If you really feel competent enough to assemble this thing, just do it. Start with the smallest box."
				(gEgo setMotion: MoveTo 85 142 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					view: 10
					setLoop: 2
					cel: 0
					cycleSpeed: 18
					setCycle: CT 2 1 self
				)
			)
			(3
				(gSoundEffects number: 411 loop: 1 flags: 1 play:)
				(box1
					view: 146
					setLoop: 2
					cel: 0
					cycleSpeed: 16
					setPri: (+ (gEgo priority:) 1)
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo dispose:)
				(box1 posn: (gEgo x:) (+ (gEgo y:) 1) setCycle: End self)
			)
			(5
				(= cycles 6)
			)
			(6
				(Print 46 1) ; "Oops."
				(= cycles 30)
			)
			(7
				(EgoDead
					948
					0
					0
					{Guess this was a bit beyond your capabilities. Speaking of bits, that's about all that remains of you. Hope you can regroup those molecules and get back to the game.}
				)
			)
		)
	)
)

(instance suxRobotS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSoundEffects number: 630 loop: -1 play:)
				(suxRobot
					init:
					setPri: 9
					setCycle: Walk
					setMotion: MoveTo 64 145 self
				)
			)
			(1
				(gSoundEffects stop:)
				(gEgo setHeading: 215 self)
			)
			(2
				(gEgo view: 146 setLoop: 3 cel: 0)
				(suxRobot setLoop: 1 cel: 0)
				(= cycles 3)
			)
			(3
				(suxRobot cel: 1)
				(= cycles 3)
			)
			(4
				(suxRobot cel: 0)
				(= cycles 3)
			)
			(5
				(suxRobot cel: 1)
				(= cycles 3)
			)
			(6
				(suxRobot cel: 0 cycleSpeed: 10 setCycle: CT 2 1 self)
				(gEgo cycleSpeed: 12 setCycle: End)
			)
			(7
				(gSoundEffects number: 411 loop: 1 play:)
				(suxRobot setCycle: End self)
			)
			(8
				(suxRobot setLoop: 2 cel: 0 cycleSpeed: 15 setCycle: Fwd)
				(= seconds 3)
			)
			(9
				(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				(robbieT
					init:
						robBust
						topGear
						robMouth
						{"Oh my. Another shredded customer. I suppose someone will be upset about this. Why do I bother."}
						0
						0
						1
						self
				)
			)
			(10
				(gLongSong2 stop:)
				(= seconds 4)
			)
			(11
				(EgoDead
					948
					0
					0
					{You seem to have had trouble maintaining your composure (not to mention your molecular structure). Get yourself together. Unfortunately, you're the universe's only hope.}
				)
			)
		)
	)
)

(instance rightRobot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 331 186 setMotion: MoveTo 111 162 self)
			)
			(1
				(gEgo setMotion: MoveTo 113 156 self)
			)
			(2
				(gEgo setMotion: MoveTo 126 151 self)
			)
			(3
				(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				(robbie
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 158 145 self
				)
			)
			(4
				(robbie setLoop: 1 cel: 0 cycleSpeed: 18 setCycle: End self)
			)
			(5
				(robbie stopUpd:)
				(robbieT
					init:
						robBust
						topGear
						robMouth
						{"Hello, sir.__Your new robot will be here in a moment."}
						0
						0
						1
						self
				)
			)
			(6
				(if register
					(gLongSong2 stop:)
					(client setScript: suxRobotS)
				else
					((ScriptID 702 1) ; robot
						init:
						posn: 192 128
						illegalBits: 0
						setLoop: -1
						setLoop: (Grooper new:)
						setCycle: Walk
						setMotion: MoveTo 83 132 self
					)
					(gEgo setAvoider: PAvoider)
				)
			)
			(7
				(gLongSong2 stop:)
				((ScriptID 702 1) setLoop: -1) ; robot
				(Face (ScriptID 702 1) gEgo self) ; robot
			)
			(8
				(Face gEgo (ScriptID 702 1) self) ; robot
			)
			(9
				(= ticks 12)
			)
			(10
				(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				(SetScore 4 157)
				(robbieT
					init:
						robBust
						topGear
						robMouth
						{"Well, there he is, sir, programmed to follow you around like a wimpering little puppy dog. How humiliating."}
						0
						0
						1
						self
				)
			)
			(11
				(gLongSong2 stop:)
				((ScriptID 702 1) illegalBits: 64 setMotion: PFollow gEgo 45) ; robot
				(SetFlag 33)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance radar of Prop
	(properties
		x 93
		y 80
		description {force field sensor}
		lookStr {The settlement of Ulence Flats is surrounded by these force field generators. They repel such undesirables such as the grell which thrive below the sands. It will allow only airborne vehicles in or out.}
		view 146
		loop 1
		cel 2
		signal 16384
		cycleSpeed 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 46 2) ; "I wouldn't mess with them if I were you."
			)
			(5 ; Talk
				(Print 46 3) ; "No answer is forthcoming."
			)
			(12 ; Smell
				(Print 46 2) ; "I wouldn't mess with them if I were you."
			)
			(11 ; Taste
				(Print 46 2) ; "I wouldn't mess with them if I were you."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance robbie of Actor
	(properties
		x 155
		y 137
		description {warehouse robot}
		lookStr {This robot is a very old model.__Somehow, he looks tired and depressed.}
		view 449
		loop 1
		signal 16384
		cycleSpeed 8
		moveSpeed 8
	)

	(method (cue)
		(gLongSong2 stop:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				(switch (++ local2)
					(0
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{It's easy for you to be chearful, isn't it? YOU don't have deteriorating flaberthrusters.}
								0
								0
								1
								self
						)
					)
					(1
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{What do you want now? I was just about finished with my internal diagnostics check. Now I'm going to have to recalibrate my photo-electric scanner membranes and begin all over again.}
								0
								0
								1
								self
						)
					)
					(2
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{Carbon-based life-forms can be sooo trying sometimes. If you haven't purchased a robot, I have nothing for you. Now, go away!}
								0
								0
								1
								self
						)
					)
					(3
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{(Sigh!) How depressing. Let's begin again from the start and proceed veeerrrryyyy sssslllooowwwllly. I do NOT want to be disturbed. You ARE disturbing me. GO AWAY! Thank you so much.}
								0
								0
								1
								self
						)
					)
					(6
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{I'm STILL ignoring you!}
								0
								0
								1
								self
						)
					)
					(else
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{I'm ignoring you.}
								0
								0
								1
								self
						)
					)
				)
			)
			(3 ; Do
				(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				(robbieT
					init:
						robBust
						topGear
						robMouth
						{Do NOT touch me! Carbon-based life-forms are notoriously filthy creatures. Everyone knows that they veritably ooze with metal-tarnishing agents.}
						0
						0
						1
						self
				)
			)
			(4 ; Inventory
				(if (OneOf invItem 4 15 10 0 2 5 11 18) ; Knife, Widget, buckazoid, Cartridge, Gadget, Dehydrated_Water, Jetpack, Droids-B-Us_coupon
					(gLongSong2 number: 622 loop: -1 flags: 1 play:)
				)
				(switch invItem
					(4 ; Knife
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{I am programmed to defend myself against all attacks. Even against such a laughable attempt at destruction as this. It would be a shame to expend the energy required to kill you, don't you agree? Yes, I thought you would.}
								0
								0
								1
								self
						)
					)
					(15 ; Widget
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{Although I am amused at your feeble attempt to modify my magnetic field, I must warn you that I can, and most definitely will, defend myself if need be. Now, please put that thing away. Thank you so much.}
								0
								0
								1
								self
						)
					)
					(10 ; buckazoid
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{Sorry, sir. I'm not allowed to accept tips.}
								0
								0
								1
								self
						)
					)
					(0 ; Cartridge
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{It appears to be some sort of data cartridge, sir, but I'm afraid I'm not equipped with the necessary port to access the information it contains.}
								0
								0
								1
								self
						)
					)
					(2 ; Gadget
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{You won't need your translation device, sir. I'm fluent in more than three million modes of spoken communication.}
								0
								0
								1
								self
						)
					)
					(5 ; Dehydrated_Water
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{No thank you, sir - I never touch the stuff.}
								0
								0
								1
								self
						)
					)
					(11 ; Jetpack
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{I've seen a jet pack much like this one reduced to slag after one brief flight. It wasn't a pretty sight.}
								0
								0
								1
								self
						)
					)
					(17 ; Bar_Coupon
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{Many of our local businesses issue these coupons for discounts through the Ulence Flats Chamber of Commerce. It's done wonders for business around here.}
								0
								0
								1
								self
						)
					)
					(18 ; Droids-B-Us_coupon
						(robbieT
							init:
								robBust
								topGear
								robMouth
								{Many of our local businesses issue thses coupons for discounts through the Ulence Flats Chamber of Commerce. It's done wonders for business around here.}
								0
								0
								1
								self
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(12 ; Smell
				(Print 46 4) ; "It smells like a fine grade of light machine oil. You were expecting Hai Karate, perhaps?"
			)
			(11 ; Taste
				(Print 46 5) ; "Why on earth - or Kerona for that matter - would you want to do that?"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance suxRobot of Actor
	(properties
		x 192
		y 128
		description {SUX robot}
		lookStr {What a fine robot you've purchased!}
		view 450
		signal 2048
		cycleSpeed 11
		moveSpeed 11
	)
)

(instance box1 of Prop
	(properties
		x 100
		y 137
		description {box}
		lookStr {Great. Three boxes of robot parts, sporting large signs which read: "Caution: This product contains explosive parts. Not intended for children under three."}
		view 146
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 3 4 11) ; Do, Inventory, Taste
			(switch local1
				(0
					(Print 46 6) ; "Unfortunately, you AREN'T smarter than you look, so you'd best leave the incredibly complex robot parts alone before you hurt yourself. Too bad they don't give rebates to retrobates."
				)
				(1
					(Print 46 7) ; "You can tell this is definitely out of your league. You can't even open the boxes, much less assemble what's inside."
				)
				(2
					(gCurRoom setScript: blowUpBox)
				)
			)
			(++ local1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance box2 of PicView
	(properties
		x 125
		y 143
		description {box}
		lookStr {Great. Three boxes of robot parts, sporting large signs which read: "Caution: This product contains explosive parts. Not intended for children under three."}
		view 146
		cel 1
		signal 16384
	)

	(method (doVerb)
		(box1 doVerb: &rest)
	)
)

(instance box3 of PicView
	(properties
		x 113
		y 131
		description {box}
		lookStr {Great. Three boxes of robot parts, sporting large signs which read: "Caution: This product contains explosive parts. Not intended for children under three."}
		view 146
		signal 16384
	)

	(method (doVerb)
		(box1 doVerb: &rest)
	)
)

(instance pickupArea of Feature
	(properties
		description {Droids-B-Us warehouse and pickup area}
		onMeCheck 2
		lookStr {This portion of the building is the warehouse where customers come to pick up their purchases.}
	)

	(method (doVerb)
		(store doVerb: &rest)
	)
)

(instance store of Feature
	(properties
		description {Droids-B-Us store}
		onMeCheck 16
		lookStr {That's the Droids-B-Us storefront. Droids-B-Us is known throughout this end of the galaxy for the best deals on new and used psionic and cybernetic systems for home, school, office, and spaceship.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y (+ ((User curEvent:) y:) 30))
		(switch theVerb
			(3 ; Do
				(Print 46 8) ; "Like many buildings on these backwater planets, this one is a quickie Construct-O-Foam job that won't last more than a couple of thousand years at the outside. They just don't make `em like they used to."
			)
			(5 ; Talk
				(Print 46 9) ; "Talking to buildings is likely to get you arrested on this planet."
			)
			(12 ; Smell
				(Print 46 10) ; "Why would you possibly care what this building smells like?"
			)
			(11 ; Taste
				(Print 46 11) ; "Oh, blecchhh!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pickupSign of Feature
	(properties
		description {sign above the door}
		onMeCheck 8
		lookStr {The badly weathered sign says "Droids-B-Us Pickup".}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y (+ ((User curEvent:) y:) 60))
		(switch theVerb
			(3 ; Do
				(Print 46 12) ; "You can't reach it."
			)
			(5 ; Talk
				(Print 46 13) ; "No matter how you try to convince it otherwise, the sign will only say "Droids-B-Us Pickup.""
			)
			(12 ; Smell
				(Print 46 14) ; "From here, you can discern no particular smell on the sign."
			)
			(11 ; Taste
				(Print 46 15) ; "If your neck was as long as a giraffazoid's, then maybe you could do that. But why would you want to?"
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance giraffe of Feature
	(properties
		description {Gerry G}
		onMeCheck 32
		lookStr {This cheerful fellow is Gerry Giraffazoid, logo, spokesbeing, and C.E.O. of Droids-B-Us, Inc.}
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y (+ ((User curEvent:) y:) 60))
		(switch theVerb
			(3 ; Do
				(Print 46 12) ; "You can't reach it."
			)
			(5 ; Talk
				(Print 46 16) ; "This isn't the real Gerry Giraffazoid, Roger - it's just a picture."
			)
			(12 ; Smell
				(Print 46 17) ; "Gerry Giraffazoid's picture doesn't smell like much of anything."
			)
			(11 ; Taste
				(Print 46 18) ; "Trust me - that logo lacks any taste."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robbieT of Talker
	(properties
		x 6
		y 26
		nsTop 8
		nsLeft 201
		view 518
	)
)

(instance robBust of View
	(properties
		view 518
		cel 1
	)
)

(instance robMouth of Prop
	(properties
		nsTop 53
		nsLeft 27
		view 518
		loop 4
		cycleSpeed 6
	)
)

(instance topGear of Prop
	(properties
		nsTop 8
		nsLeft 39
		view 518
		loop 3
		cycleSpeed 6
	)
)

(instance leftGear of Prop ; UNUSED
	(properties
		nsTop 31
		nsLeft 176
		view 518
		loop 1
		cycleSpeed 6
	)
)

(instance rightGear of Prop ; UNUSED
	(properties
		nsTop 22
		nsLeft 244
		view 518
		loop 2
		cycleSpeed 6
	)
)

