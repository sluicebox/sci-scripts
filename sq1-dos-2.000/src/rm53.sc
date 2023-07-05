;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm53 0
)

(local
	local0
	local1
	local2
)

(instance rm53 of SQRoom
	(properties
		lookStr {You have fallen into an airlock aboard the Sarien ship Deltaur.}
		picture 53
	)

	(method (init)
		(LoadMany rsVIEW 34 35 153 456)
		(Load rsPIC 153)
		(LoadMany rsSCRIPT 991 941)
		(LoadMany rsSOUND 527 504 520 526 311 525 417)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 127 171 196 171 255 135 248 114 240 111 225 120 201 109 245 81 242 0 319 0 319 189 0 189 0 0 224 0 224 69 204 94 186 107 164 95 148 102 113 97 71 121 67 145
					yourself:
				)
		)
		(jetPack init: hide:)
		(machine setCycle: Fwd)
		(self setScript: roomControl)
		(super init:)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((& (gEgo onControl: 1) $0200)
				(if (> (droidEnter state:) 4)
					(gEgo setScript: walkOut)
				)
				(if (> (droidEnter state:) 11)
					(SetFlag 73)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance pushEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
				(HandsOff)
			)
			(1
				(Print 53 0) ; ""Outta my way!" beeps the rude little droid."
				(fireDroid setMotion: 0 ignoreActors: 1)
				(gSoundEffects number: 527 loop: 1 play:)
				(fireDroid setMotion: 0)
				(gEgo
					setPri: (gEgo priority:)
					posn: (gEgo x:) (- (gEgo y:) 24)
					view: 70
					setMotion: 0
					cycleSpeed: 8
					setLoop: 0
					cel: 0
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: CT 11 -1 self)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo setCycle: CT 11 -1 self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(= cycles 60)
			)
			(7
				(EgoDead 945 0 0 53 1) ; "Bumping you, the droid causes you to come into contact with exposed wiring. Your heart, not to mention the rest of your body, doesn't react well to this (have you ever seen rhubarb pie without the crust?). Guess you'll have to be a little more clever next time."
				(self dispose:)
			)
		)
	)
)

(instance droidEnter of Script
	(properties)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((< state 3) 0)
			((> state 12) 0)
			((& (fireDroid signal:) $0400)
				(gEgo setScript: pushEgo self)
				(-- state)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(droidSound
					number: 525
					loop: -1
					flags: 1
					play: 30
					fade: 127 25 10 0
				)
				(fireDroid init: setCycle: Fwd)
				(= cycles 3)
			)
			(2
				(if (& (gEgo onControl: 1) $0022)
					(HandsOff)
				)
				(door setCycle: End self)
				(door ignoreActors: 1)
			)
			(3
				(fireDroid setMotion: PolyPath 225 90 self)
			)
			(4
				(if (& (gEgo onControl: 1) $0da2)
					(self setScript: blastEgo self)
				else
					(HandsOn)
					(= cycles 3)
				)
			)
			(5
				(fireDroid setMotion: PolyPath 185 117 self)
			)
			(6
				(fireDroid setMotion: PolyPath 182 138 self)
			)
			(7
				(fireDroid
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(8
				(= local0 1)
				(gSoundEffects number: 417 loop: 1 play:)
				(fireDroid setLoop: 1 cel: 3 setCycle: End self)
			)
			(9
				(jetPack posn: 148 149 view: 456 setLoop: 2 cel: 0)
				(= cycles 3)
			)
			(10
				(fireDroid setLoop: 4 cel: 0 setCycle: End self)
			)
			(11
				(fireDroid
					setLoop: 3
					cel: 0
					setCycle: Fwd
					cycleSpeed: 5
					setMotion: PolyPath 190 110 self
				)
			)
			(12
				(fireDroid setMotion: PolyPath 230 95 self)
			)
			(13
				(droidSound fade:)
				(if (not (& (gEgo onControl: 1) $0022))
					(door ignoreActors: 0 setCycle: Beg self)
				)
			)
			(14
				(self dispose:)
				(EgoDead 945 0 0 53 2) ; "You missed a golden opportunity while that door was open. Oh well, what's new. All alone and by yourself, you grow incredibly hungry and begin sampling your own body parts. Finding that you have absolutely no taste, (like we didn't already know that) you end up shriveling away to nothing and dying in the process."
			)
		)
	)
)

(instance fireDroidBrRect of Code
	(properties)

	(method (doit param1)
		(if (<= (param1 loop:) 2)
			(param1
				brLeft: (- (param1 x:) 22)
				brTop: (- (param1 y:) 12)
				brRight: (+ (param1 x:) 17)
				brBottom: (+ (param1 y:) 7)
			)
		else
			(param1
				brLeft: (- (param1 x:) 17)
				brTop: (- (param1 y:) 12)
				brRight: (+ (param1 x:) 22)
				brBottom: (+ (param1 y:) 7)
			)
		)
	)
)

(instance blastEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 53 3 #at 40 10) ; "ALERT ! ALERT ! Organic contamination detected in airlock."
				(gEgo setMotion: 0)
				(machine setCycle: Fwd)
				(Face gEgo fireDroid self)
			)
			(1
				(gSoundEffects number: 312 loop: 1 play:)
				(= local1 (Graph grSAVE_BOX 30 48 190 265 1))
				(Graph
					grDRAW_LINE
					61
					149
					(- (gEgo y:) 16)
					(gEgo x:)
					global152
					1
					0
					0
				)
				(Graph
					grDRAW_LINE
					61
					149
					(- (gEgo y:) 19)
					(gEgo x:)
					global132
					1
					0
					0
				)
				(Graph
					grDRAW_LINE
					61
					149
					(- (gEgo y:) 22)
					(gEgo x:)
					global137
					1
					0
					0
				)
				(Graph grREDRAW_BOX 30 48 190 265)
				(= seconds 2)
			)
			(2
				(Graph grRESTORE_BOX local1)
				(Graph grREDRAW_BOX 30 48 190 265)
				(= local1 0)
				(= seconds 1)
			)
			(3
				(if (& (gEgo onControl: 1) $0520)
					(gEgo setLoop: 1)
				)
				(if (& (gEgo onControl: 1) $0880)
					(gEgo setLoop: 2)
				)
				(gEgo view: 71 cel: 0 cycleSpeed: 11 setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(EgoDead 940 1 0 53 4) ; "Those laser shots are incredibly effective as your body will attest. Being in plain sight probably didn't help you much."
				(self dispose:)
			)
		)
	)
)

(instance roomControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					init:
					hide:
					cel: 0
					view: 34
					posn: 77 33
					setLoop: 12
					setStep: 6 6
					normal: 0
				)
				(HandsOff)
				(door init: ignoreActors: 0)
				(doorPanel_a init:)
				(machine init:)
				(gEgo setScript: zoomIn self)
			)
			(1
				(= seconds 3)
			)
			(2
				(self setScript: CloseDoors self)
			)
			(3
				(= seconds 10)
			)
			(4
				(self setScript: droidEnter self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance CloseDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom overlay: 153 100)
				(gLongSong2 number: 504 loop: 1 play: self hold: 1)
				(bayDoor init: setPri: 0 cycleSpeed: 25 setCycle: CT 2 1 self)
			)
			(1
				(gLongSong2 hold: 0)
				(bayDoor dispose:)
			)
			(2
				(gLongSong number: 520 loop: 1 play: self)
			)
			(3
				(gLongSong number: 538 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fireDroid setMotion: 0 setScript: 0)
				(gEgo
					ignoreControl: 2
					ignoreActors: 1
					setMotion: PolyPath 208 77 self
				)
				(HandsOff)
			)
			(1
				(door ignoreActors: 0 setCycle: Beg self)
				(gEgo setMotion: PolyPath 220 77)
			)
			(2
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance zoomIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 6)
			)
			(1
				(gSoundEffects number: 505 loop: 1 play:)
				(gEgo
					show:
					setCycle: RandCycle
					setMotion: MoveTo 102 96 self
				)
			)
			(2
				(gEgo
					cel: 0
					view: 35
					setLoop: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 setLoop: 1 posn: 89 149 setCycle: CT 3 1 self)
			)
			(4
				(gEgo setCycle: End)
				(jetPack
					show:
					moveSpeed: 4
					setCycle: RandCycle
					setMotion: PackJump 185 130 self
				)
			)
			(5
				(gSoundEffects number: 526 loop: 1 play:)
				(jetPack cel: 0 setCycle: End setMotion: PackJump 161 152 self)
			)
			(6
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 142 150 143 142 167 138 175 148 174 154 152 158
							yourself:
						)
				)
				(gSoundEffects number: 526 loop: 1 play:)
				(jetPack
					posn: 138 149
					view: 153
					setLoop: 1
					cel: 0
					setCycle: Fwd
				)
				(= ticks 18)
			)
			(7
				(HandsOn)
				(gEgo put: 11 53) ; Jetpack
				(NormalEgo 0 1 61)
				(self dispose:)
			)
		)
	)
)

(instance PackJump of JumpTo
	(properties)

	(method (doit)
		(if (>= (++ b-moveCnt) (client moveSpeed:))
			(= b-moveCnt 0)
			(super doit:)
		)
	)
)

(instance doorPanel_a of Feature
	(properties
		name {doorPanel}
		description {Keycard slot}
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 53 5 #at 40 10) ; "This seems to be some sort of special door control panel. It requires some sort of special keycard which you obviously don't have."
			)
			(3 ; Do
				(Print 53 6 #at 40 10) ; "There is nothing you can do to it without one of those keycards."
			)
			(12 ; Smell
				(Print 53 7 #at 40 10) ; "You would have to take your helmet off to do that and it's not a very good idea right now."
			)
			(11 ; Taste
				(Print 53 8 #at 40 10) ; "You can't do that with a helmet on."
			)
			(5 ; Talk
				(Print 53 9 #at 40 10) ; "Your screams will do nothing in this airlock."
			)
			(4 ; Inventory
				(Print 53 10 #at 40 10) ; "That appears to have no noticeable affect on the panel."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fireDroid of Actor
	(properties
		x 238
		y 81
		view 456
		signal 2048
		cycleSpeed 5
		moveSpeed 7
	)

	(method (init)
		(super init: &rest)
		(self baseSetter: fireDroidBrRect)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 53 11 #at 40 10) ; "It appears to be some sort of high-tech fire droid."
			)
			(3 ; Do
				(Print 53 12 #at 40 10) ; "There is nothing you can do to this droid. It's virtually indestructable."
			)
			(12 ; Smell
				(Print 53 13 #at 40 10) ; "If you could smell through your helmet you would know that this droid smells like smoke and fire."
			)
			(11 ; Taste
				(Print 53 14 #at 40 10) ; "Not out here."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 53 15 #at 40 10) ; "Intent on his cleaning duties, the little droid ignores your feeble attempts at a bribe."
					)
					(0 ; Cartridge
						(Print 53 16) ; "The droid seems totally unconcerned with the data cartridge."
					)
					(15 ; Widget
						(Print 53 17) ; "The widget and the droid do not appear to have any affect on one another."
					)
					(2 ; Gadget
						(Print 53 18) ; "This robot is not equipped with speech circuits, therefore there's nothing to translate."
					)
					(4 ; Knife
						(Print 53 19) ; "He doesn't seem threatened, does he?"
					)
					(5 ; Dehydrated_Water
						(Print 53 20) ; "Somehow you doubt the droid would have need of water."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(Print 53 21 #at 40 10) ; "It's much to busy to spend time talking to the likes of you."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 204
		y 103
		view 153
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 53 22 #at 40 10) ; "The airlock door looks unfortunately thick and sturdy."
			)
			(3 ; Do
				(Print 53 23 #at 40 10) ; "This door is designed to withstand the vacuum of space. I seriously doubt that you could do anything to it."
			)
			(12 ; Smell
				(Print 53 24) ; "The door smells much like other doors you have sniffed in the past."
			)
			(11 ; Taste
				(Print 53 25) ; "The taste of the door - ferrous metal with just the slightest nuance of industrial-strength bulkead polish - reveals no new insights."
			)
			(5 ; Talk
				(Print 53 26 #at 40 10) ; "Shouting for help would be useless at best and fatal at worst."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setCycle)
		(super setCycle: &rest)
		(doorSound number: 311 loop: 1 play:)
	)
)

(instance machine of Prop
	(properties
		x 146
		y 68
		onMeCheck 16384
		view 153
		loop 2
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 53 27 #at 40 10) ; "It appears to be a decontamination unit, something like the ones used to zap Andromedan cockroaches aboard the Arcada. You wonder what it's here for."
			)
			(3 ; Do
				(Print 53 28 #at 40 10) ; "Touching these things can be hazardous to your health."
			)
			(12 ; Smell
				(Print 53 29 #at 40 10) ; "Ozone. Definitely ozone."
			)
			(11 ; Taste
				(Print 53 30 #at 40 10) ; "After seeing what a decontaminator can do to an unwary cockroach, you've never had the least desire to lick one."
			)
			(5 ; Talk
				(Print 53 31 #at 40 10) ; "You really don't want to attract its attention."
			)
			(4 ; Inventory
				(Print 53 32 #at 40 10) ; "That just doesn't seem to work here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jetPack of Actor
	(properties
		x 116
		y 134
		view 35
		loop 2
		signal 18432
		cycleSpeed 4
		moveSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== local0 1)
					(Print 53 33 #at 40 10) ; "Well it looks like you won't be using that unit again."
				else
					(Print 53 34 #at 40 10) ; "Your overheating backpack lies smoking on the floor - you hope that it doesn't explode."
				)
			)
			(3 ; Do
				(if (== local0 1)
					(Print 53 35 #at 40 10) ; "It's pretty much useless. No sense in wasting your time on it now."
				else
					(Print 53 36 #at 40 10) ; "You don't want to go near it. It may explode."
				)
			)
			(12 ; Smell
				(if (== local0 1)
					(Print 53 37 #at 40 10) ; "The jetpack is soaked in foam fire retardant. I'd pass if I were you."
				else
					(Print 53 38 #at 40 10) ; "You can't vent your suit enough to do that in the airlock."
				)
			)
			(11 ; Taste
				(Print 53 39 #at 40 10) ; "You can't taste anything from here."
			)
			(5 ; Talk
				(Print 53 40 #at 40 10) ; "You can talk to it all you want, but it's still damaged beyond repair."
			)
			(4 ; Inventory
				(if (== local0 1)
					(Print 53 41 #at 40 10) ; "The only item that might be useful is a blow dryer and you don't have one."
				else
					(Print 53 42 #at 40 10) ; "The only item that would be of any use right now would be a fire extingisher and you don't seem to have one right now."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorPanel_b of Feature ; UNUSED
	(properties
		name {doorPanel}
		description {Keycard slot}
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 53 43 #at 40 10) ; "This seems to be some sort of special door control panel. It seems to require some sort of special keycard which you obviously don't have. You'll need to try something else."
			)
			(3 ; Do
				(Print 53 6 #at 40 10) ; "There is nothing you can do to it without one of those keycards."
			)
			(12 ; Smell
				(Print 53 44 #at 40 10) ; "You would have to take off your helmet to do that. It's a poor idea at this time."
			)
			(11 ; Taste
				(Print 53 8 #at 40 10) ; "You can't do that with a helmet on."
			)
			(5 ; Talk
				(Print 53 45 #at 40 10) ; "Your screams will do nothing but let the Sariens know you're here."
			)
			(4 ; Inventory
				(Print 53 10 #at 40 10) ; "That appears to have no noticeable affect on the panel."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance doorSound of Sound
	(properties
		number 311
	)
)

(instance bayDoor of Prop
	(properties
		x 141
		y 114
		view 153
		loop 3
	)
)

(instance droidSound of Sound
	(properties
		number 525
	)
)

