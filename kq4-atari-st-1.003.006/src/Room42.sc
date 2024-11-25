;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room42 0
)

(synonyms
	(room cottage)
	(shelf cabinet)
	(woman woman)
	(fisherman man)
)

(local
	local0
	[local1 3]
	local4
	local5
	local6
	local7
	local8
	local9
)

(instance Room42 of Rm
	(properties
		picture 42
		style 16
	)

	(method (init)
		(Load rsVIEW 513)
		(if (gEgo has: 1) ; Diamond_Pouch
			(Load rsVIEW 243)
			(Load rsVIEW 242)
			(Load rsVIEW 240)
			(Load rsVIEW 241)
		)
		(super init:)
		(= gIndoors 1)
		(if (gEgo has: 1) ; Diamond_Pouch
			(= local9 1)
		)
		(gEgo
			view: 4
			loop: 0
			setStep: 4 2
			illegalBits: $8000
			setPri: -1
			posn: 63 125
			init:
		)
		((= local8 (Prop new:))
			view: 513
			posn: 133 84
			setLoop: 2
			ignoreActors: 1
			init:
			cycleSpeed: 1
			setCycle: Fwd
		)
		(if (gEgo has: 1) ; Diamond_Pouch
			((View new:) view: 513 loop: 0 cel: 2 posn: 181 93 addToPic:)
			((= local4 (Act new:))
				view: 241
				loop: 0
				setCycle: Fwd
				x: 200
				y: 117
				illegalBits: 0
				init:
				setScript: doBread
			)
			((View new:) view: 513 loop: 3 cel: 0 posn: 82 154 addToPic:)
		else
			(if (and (== global116 3) (!= ((gInventory at: 1) owner:) 42)) ; Diamond_Pouch
				((= local4 (Act new:))
					view: 240
					illegalBits: 0
					loop: 2
					posn: 84 132
					ignoreActors: 1
					init:
					setPri: 12
					setScript: wifeTalk
				)
			else
				((= local4 (Act new:))
					view: 240
					loop: 3
					illegalBits: 0
					posn: 84 132
					ignoreActors: 1
					init:
					setPri: 12
					setScript: wifeTalk
				)
			)
			((= local5 (Act new:))
				view: 240
				loop: 4
				cel: 1
				illegalBits: 0
				posn: 84 153
				init:
				setPri: 12
			)
			(chairBlock
				top: (- (local5 y:) 5)
				bottom: (+ (local5 y:) 5)
				left: (- (local5 x:) 13)
				right: (+ (local5 x:) 15)
				init:
			)
			(gEgo observeBlocks: chairBlock)
		)
		(if (== global116 3)
			((View new:) view: 513 loop: 0 cel: 2 posn: 181 93 addToPic:)
			((= local6 (Act new:))
				view: 235
				loop: 0
				cel: 0
				ignoreActors: 1
				illegalBits: 0
				posn: 130 135
				init:
				setPri: 12
				setScript: fishermanSit
			)
			((= local7 (View new:))
				view: 235
				loop: 2
				cel: 0
				posn: 129 157
				init:
				stopUpd:
				setPri: 12
			)
			(if (== ((gInventory at: 17) owner:) 204) ; Fishing_Pole
				((= local0 (Act new:))
					view: 513
					loop: 1
					cel: 0
					illegalBits: 0
					posn: 223 115
					init:
					stopUpd:
					ignoreActors: 1
				)
			)
		else
			((View new:) view: 513 loop: 3 cel: 1 posn: 138 161 addToPic:)
		)
	)

	(method (doit)
		(if (& (gEgo onControl: 0) $0040)
			(gEgo loop: 1)
			(Animate (gCast elements:) 0)
			(gCurRoom newRoom: 7)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look[<around][/room,room,place]')
					(if local9
						(Print
							(Format ; "The inside of the fisherman's shack looks almost as shabby as the outside. %s"
								@global300
								42
								0
								(cond
									((not (gCast contains: local6)) {You see a tired-looking woman kneading bread at the counter.})
									((not (gEgo has: 17)) {You see the old fisherman at the table, and his wife kneading bread at the counter. The fisherman's fishing pole has been set in the corner.}) ; Fishing_Pole
									((not (gEgo has: 1)) {You see the old fisherman at the table, and his wife kneading bread at the counter. Since your generous gift of the diamonds, however, her grouchy look has been replaced by one of contentment.}) ; Diamond_Pouch
									(else { })
								)
							)
						)
					else
						(Print
							(Format ; "The inside of the fisherman's shack looks almost as shabby as the outside. %s"
								@global300
								42
								0
								(cond
									((not (gCast contains: local6)) {You see a tired-looking woman knitting at the table.})
									((not (gEgo has: 17)) {The fisherman's worn and tattered wife sits at the table with her husband, talking. The fisherman's pole has been set into the corner.}) ; Fishing_Pole
									((not (gEgo has: 1)) {The fisherman's worn and tattered wife sits at the table with her husband, talking. Since your generous gift of the diamonds, however, her grouchy look has been replaced by one of contentment.}) ; Diamond_Pouch
									(else { })
								)
							)
						)
					)
				)
				((and (gCast contains: local6) (Said '/person'))
					(Print 42 1) ; "Both a man and a woman are here. Be more specific."
				)
				((Said '/people')
					(if (gCast contains: local6)
						(Print 42 1) ; "Both a man and a woman are here. Be more specific."
					else
						(Print 42 2) ; "There is only one person here."
					)
				)
				((Said 'look>')
					(cond
						((Said '/woman,person')
							(cond
								(local9
									(cond
										((not (gEgo has: 17)) ; Fishing_Pole
											(Print 42 3) ; "A poor and tattered woman kneads bread dough at the counter. She looks very tired, and a little grumpy."
										)
										((not (gEgo has: 1)) ; Diamond_Pouch
											(Print 42 4) ; "A poor and tattered woman kneads bread dough at the counter. Since your generous gift of the diamonds, however, her grouchy look has been replaced by one of contentment."
										)
									)
								)
								((!= global116 3)
									(Print 42 5) ; "A poor and tattered woman knits at the table. She looks very tired, and a little grumpy."
								)
								((== ((gInventory at: 1) owner:) 42) ; Diamond_Pouch
									(Print 42 6) ; "The fisherman's worn and tattered wife sits at the table with her husband, talking. Since your generous gift of the diamonds, however, her grouchy look has been replaced by one of contentment."
								)
								(else
									(Print 42 7) ; "The grizzled old fisherman and his tattered wife sit at their table, talking."
								)
							)
						)
						((Said '/dough[<bread]')
							(Print 42 8) ; "It just looks like plain old bread dough."
						)
						((Said '<under/table')
							(Print 42 9) ; "There is nothing of interest under the table."
						)
						((Said '/table')
							(Print 42 10) ; "It looks like an old worn table."
						)
						((Said '/chair')
							(Print 42 11) ; "Yep, those are chairs, all right!"
						)
						((Said '<under/bed')
							(Print 42 12) ; "There is nothing under the bed."
						)
						((Said '/bed')
							(Print 42 13) ; "The lumpy bed looks old and uninviting."
						)
						((Said '/stove')
							(Print 42 14) ; "At least the stove keeps it warm in here."
						)
						((Said '/window')
							(cond
								(
									(or
										(gEgo inRect: 14 127 52 140)
										(gEgo inRect: 66 110 88 119)
									)
									(Print 42 15) ; "You see the ocean out the window."
								)
								((gEgo inRect: 236 118 261 139)
									(Print 42 16) ; "You see the meadow out the window."
								)
								(else
									(Print 800 1) ; "You're not close enough."
								)
							)
						)
						((Said '/door')
							(Print 42 17) ; "This is a plain wooden door."
						)
						((Said '/wall')
							(Print 42 18) ; "There is nothing of importance on the walls."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 42 19) ; "There is nothing of interest on the floor."
						)
						((Said '/pole')
							(cond
								(
									(and
										(== global116 3)
										(== ((gInventory at: 17) owner:) 204) ; Fishing_Pole
									)
									(Print 42 20) ; "Yep. It's there, all right!"
								)
								((gEgo has: 17) ; Fishing_Pole
									(event claimed: 0)
								)
								(else
									(Print 42 21) ; "What pole?"
								)
							)
						)
						((Said '/fisherman')
							(cond
								((!= global116 3)
									(Print 42 22) ; "What fisherman?"
								)
								((not local9)
									(Print 42 23) ; "The grizzled old fisherman and his tattered wife sit at their table talking and drinking hot coffee."
								)
								((== ((gInventory at: 1) owner:) 42) ; Diamond_Pouch
									(Print 42 24) ; "The salty old fisherman now looks satisfied as he sits at his table. Obviously, your generous gift pleased him."
								)
								(else
									(Print 42 25) ; "The old fisherman sits dejectedly at the table, drinking a mug of hot coffee."
								)
							)
						)
						((Said '/caldron,kettle,coffee')
							(Print 42 26) ; "The smell of hot coffee fills the room."
						)
						((Said '/fish')
							(if (not (gEgo has: 24)) ; Dead_Fish
								(Print 42 27) ; "You see a large fish hanging on the wall."
							else
								(event claimed: 0)
							)
						)
						((Said '/shelf')
							(Print 42 28) ; "You see a cupboard filled with canned goods."
						)
						((Said '/can')
							(Print 42 29) ; "These poor people can only afford a few cheap cans of food."
						)
						((Said '/knitting,knitting')
							(if
								(and
									(== (local4 view:) 240)
									(== (local4 loop:) 3)
								)
								(Print 42 30) ; "You're not interested in the knitting."
							else
								(Print 42 31) ; "What knitting?"
							)
						)
					)
				)
				((Said 'eat/dough')
					(Print 42 32) ; "You don't like it."
				)
				((Said 'rob/pole')
					(cond
						(
							(and
								(== ((gInventory at: 17) owner:) 204) ; Fishing_Pole
								(== global116 3)
							)
							(Print 42 33) ; "You are not a thief, Rosella!"
						)
						(((gInventory at: 17) ownedBy: gEgo) ; Fishing_Pole
							(Print 800 0) ; "You already took it."
						)
						(else
							(Print 42 21) ; "What pole?"
						)
					)
				)
				((Said 'kiss>')
					(cond
						((Said '[/!*]')
							(if (== global116 3)
								(Print 42 34) ; "Please be more specific as to whom you want to kiss!"
							else
								(Print 42 35) ; "She wouldn't appreciate it."
							)
						)
						((Said '/woman,person')
							(Print 42 35) ; "She wouldn't appreciate it."
						)
						((Said '/fisherman')
							(if (== global116 3)
								(Print 42 36) ; "You think, for a moment, that it might help, but then change your mind."
							else
								(Print 42 37) ; "There ain't no fisherman here!"
							)
						)
					)
				)
				((Said 'help')
					(Print 42 38) ; "How can you do that, Rosella?!"
				)
				(
					(or
						(Said 'talk/woman,person')
						(and
							(< (gEgo distanceTo: local4) 50)
							(Said 'talk[/!*]')
						)
					)
					(cond
						((== ((gInventory at: 1) owner:) 42) ; Diamond_Pouch
							(wifeTacoDoco2 cue:)
						)
						((gCast contains: local6)
							(wifeTacoDoco1 cue:)
						)
						(else
							(wifeTacoDoco cue:)
						)
					)
				)
				(
					(or
						(Said 'talk/fisherman')
						(and
							(gCast contains: local6)
							(< (gEgo distanceTo: local6) 50)
							(Said 'talk[/!*]')
						)
					)
					(if (== global116 3)
						(if (== ((gInventory at: 1) owner:) 42) ; Diamond_Pouch
							(fishermanTacoDoco1 cue:)
						else
							(fishermanTacoDoco2 cue:)
						)
					else
						(Print 42 39) ; "You'll be talking to yourself."
					)
				)
				((Said 'talk[/!*]')
					(cond
						((gCast contains: local6)
							(Print 42 40) ; "There is a fisherman and his wife here. Please direct your comments to whom you wish to speak."
						)
						((== ((gInventory at: 1) owner:) 42) ; Diamond_Pouch
							(wifeTacoDoco2 cue:)
						)
						((gCast contains: local6)
							(wifeTacoDoco1 cue:)
						)
						(else
							(wifeTacoDoco cue:)
						)
					)
				)
				((Said 'close,open/door')
					(Print 42 41) ; "There's no need for that."
				)
				((Said 'sit')
					(Print 42 42) ; "You don't have time for that!"
				)
				((or (Said 'lay,sleep[<down,on,in]') (Said 'get<in,on,in/bed'))
					(Print 42 13) ; "The lumpy bed looks old and uninviting."
				)
				((Said 'drink,get/coffee,cup')
					(Print 42 43) ; "You don't like coffee."
				)
				((Said 'give>')
					(if
						(or
							(< (gEgo distanceTo: local4) 20)
							(and
								(gCast contains: local6)
								(< (gEgo distanceTo: local7) 30)
							)
						)
						(if
							(and
								(= temp0 (gInventory saidMe:))
								(gEgo has: (gInventory indexOf: temp0))
							)
							(cond
								(
									(and
										(== (gInventory indexOf: temp0) 1)
										(== global116 3)
									)
									(if (< (gEgo distanceTo: local4) 25)
										(Print 42 44) ; "You give the pouch of diamonds to the astonished woman. She and her husband exchange glances. "Wife, give the girl my fishing pole in trade," he tells his tired wife. Obediently, she retrieves the pole and hands it to you. "Thank you very much," she says, smiling. "You have certainly helped us.""
									else
										(Print 42 45) ; "You offer the pouch of diamonds to the fisherman, who takes it gladly. "Wife, give the girl my fishing pole in trade," he tells his tired wife. Obediently, she retrieves the pole and hands it to you. "Thank you very much," she says, smiling. "You have certainly helped us.""
									)
									(gEgo put: 1 42) ; Diamond_Pouch
									(local4 setScript: givePole)
								)
								((== global116 3)
									(Print 42 46) ; "The fisherman and his wife look at it in interest, but then shrug and shake their heads."
								)
								(else
									(Print 42 47) ; "The woman is already upset that you're here. Don't be bothering her with things!"
								)
							)
						else
							(if temp0
								(Print 800 2) ; "You don't have it."
							else
								(Print 42 48) ; "It's not yours to give."
							)
							(event claimed: 1)
						)
					else
						(Print 800 1) ; "You're not close enough."
						(event claimed: 1)
					)
				)
				((Said 'get,rob>')
					(cond
						((Said '/knitting')
							(Print 42 49) ; "No. It's not yours."
						)
						((Said '/pole')
							(cond
								(
									(and
										(== ((gInventory at: 17) owner:) 204) ; Fishing_Pole
										(== global116 3)
									)
									(Print 42 50) ; "You can't take their fishing pole, as that's their only means of survival!"
								)
								(((gInventory at: 17) ownedBy: gEgo) ; Fishing_Pole
									(Print 42 51) ; "You already have the pole."
								)
								(else
									(Print 42 21) ; "What pole?"
								)
							)
						)
						((Said '/dough')
							(Print 42 52) ; "You have no need for bread dough."
						)
						((Said '/woman,person')
							(Print 42 53) ; "You couldn't get the fisherman's wife."
						)
						((Said '/fisherman')
							(if (== global116 3)
								(Print 42 54) ; "You couldn't get the fisherman."
							)
						)
						((Said '/caldron')
							(Print 42 55) ; "You don't need it."
						)
						((Said '/can')
							(Print 42 56) ; "You can't."
						)
						((Said '/fish')
							(Print 42 57) ; "It's firmly attached to the wall."
						)
					)
				)
				((Said 'make/bed')
					(Print 42 58) ; "You don't have time for that."
				)
			)
		)
	)
)

(instance doBread of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Timer setReal: self 5)
			)
			(1
				(local4 setLoop: 1)
				(Timer setReal: self 3)
			)
			(2
				(local4 setLoop: 0)
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance givePole of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(HandsOff)
				(if (gEgo inRect: 185 115 239 124)
					(gEgo setMotion: MoveTo (gEgo x:) 125)
				)
				(local4
					view: 242
					loop: 0
					cel: 0
					setAvoider: (Avoid new:)
					setCycle: Walk
					setMotion: MoveTo 223 118 self
				)
			)
			(1
				(LookAt gEgo local4)
				(local0 dispose:)
				(local4
					view: 243
					setLoop: -1
					cel: 0
					setMotion: Chase gEgo 20 self
				)
			)
			(2
				(gEgo get: 17) ; Fishing_Pole
				(gGame changeScore: 3)
				(= global182 1)
				(local4 view: 242 loop: 0 cel: 0 setMotion: MoveTo 200 118 self)
			)
			(3
				(HandsOn)
				(local4
					view: 241
					setAvoider: 0
					loop: 0
					setCycle: Fwd
					setScript: doBread
				)
			)
		)
	)
)

(instance wifeTalk of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client cycleSpeed: 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				((ScriptID 0 4) setReal: self 2) ; timer1
			)
			(1
				(= state -1)
				(client cel: 0 setCycle: 0)
				(if (== (client loop:) 3)
					((ScriptID 0 4) setReal: self 1) ; timer1
				else
					((ScriptID 0 4) setReal: self 5) ; timer1
				)
			)
		)
	)
)

(instance fishermanSit of Script
	(properties)

	(method (init param1)
		(super init: param1)
		(client cycleSpeed: 2)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 0 cel: 0 setCycle: Fwd)
				(Timer setReal: self 3)
			)
			(1
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(Timer setReal: self 2)
			)
			(3
				(= state -1)
				(client setCycle: Beg)
				(Timer setReal: self 10)
			)
		)
	)
)

(instance wifeTacoDoco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global206
					(self cue:)
					(return)
				)
				(Print 42 59) ; "You introduce yourself to the old fisherman's wife. With little patience, she responds, "What're you doin' here, young lady?! Can't you see I'm busy?! We have enough problems without worryin' 'bout you!""
				(= global206 1)
			)
			(1
				(if (> global206 1)
					(self cue:)
					(return)
				)
				(Print 42 60) ; "You try to talk pleasantly to the tired-looking woman, but your words fall on deaf ears. She is obviously annoyed by your presence."
				(= global206 2)
			)
			(2
				(= state 1)
				(Print 42 61) ; "I said GIT, and I mean GIT!"
			)
		)
	)
)

(instance wifeTacoDoco1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global206
					(self cue:)
					(return)
				)
				(Print 42 62) ; "You say hello to the poor woman. With little patience, she responds, "What're you doin' in here, young lady?! Can't you see I'm busy?! We have enough problems without worryin' 'bout you!""
				(= global206 1)
			)
			(1
				(= state 0)
				(Print 42 63) ; "You try to talk pleasantly to the tired-looking woman, but your words seem to fall on deaf ears. She is obviously annoyed by your presence."
			)
		)
	)
)

(instance wifeTacoDoco2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< global206 0)
					(self cue:)
					(return)
				)
				(= global206 -1)
				(Print 42 64) ; "You speak to the fisherman's wife. She smiles as she replies, "You're a very kind girl. You've helped us out a lot. Why, I might even be able ta buy some bran' new clothes!""
			)
			(1
				(= state 0)
				(Print
					(Format ; "You say a few words to the woman, but she seems not to hear you as she is humming softly to herself while %s."
						@global300
						42
						65
						(if (== (local4 view:) 241)
							{kneading the bread}
						else
							{knitting}
						)
					)
				)
			)
		)
	)
)

(instance fishermanTacoDoco1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 42 66) ; "You speak to the old fisherman, and he replies, "You've really helped me and the missus, girlie! Those diamonds will come in awful handy. We can't thank ya enough!""
			)
			(1
				(= state 0)
				(Print 42 67) ; "Again, you say a few words to the fisherman. "All right, already!" he exclaims. "I told ya that I was grateful! Don't you have somethin' else ta do?""
			)
		)
	)
)

(instance fishermanTacoDoco2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 42 68) ; "You talk to the grizzled fisherman as he sits at the table. Sighing, he tells you, "Them fish ain't been bitin' lately. If things don't git better soon, I don't know WHAT to do!""
			)
			(1
				(Print 42 69) ; "In reply, the old fisherman comments, "Me and the wife ain't gettin' any younger, and times is tough. If you've got any ideas, girlie, let me know.""
			)
			(2
				(= state 1)
				(Print 42 70) ; "The fisherman chooses to ignore your attempted conversation. Instead, he looks dismally into his coffee cup and sighs heavily."
			)
		)
	)
)

(instance chairBase of Code ; UNUSED
	(properties)

	(method (doit param1)
		(param1 brTop: (- (param1 y:) 5))
		(param1 brLeft: (- (param1 x:) 16))
		(param1 brBottom: (+ (param1 y:) 1))
		(param1 brRight: (+ (param1 x:) 5))
	)
)

(instance chairBlock of Blk
	(properties)
)

