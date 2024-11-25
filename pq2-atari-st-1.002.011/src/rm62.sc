;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm62 0
)

(synonyms
	(footprint footprint)
	(diver diver cop man diver)
	(scratch cut)
)

(local
	[local0 100]
	local100
	local101
	local102
	local103
	local104
	local105
	local106
)

(procedure (localproc_0)
	(if (gEgo has: 10) ; field_kit
		(return 1)
	else
		(Print 62 0) ; "You have to have your field kit to do that."
		(return 0)
	)
)

(procedure (localproc_1)
	(Print &rest #at -1 22)
)

(procedure (localproc_2)
	(Print &rest #at -1 128)
)

(instance tmpSound of Sound
	(properties)
)

(instance diver of Act
	(properties)
)

(instance blood of View
	(properties)
)

(instance bloodView of View
	(properties)
)

(instance bains of Act
	(properties)
)

(instance car of Act
	(properties)
)

(instance smoke of Prop
	(properties)
)

(instance bloodBlock of Blk
	(properties
		top 72
		left 70
		bottom 85
		right 95
	)
)

(instance keithAmbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local103 1)
				(gEgo loop: 0 setMotion: 0 stopUpd:)
				(= global189 1)
				(localproc_1 62 1 83) ; "As you inspect the evidence, Keith ambles into view..."
				(global112 setMotion: MoveTo 150 79 self)
			)
			(1
				(localproc_2 62 2) ; "Keith pipes up, "Hey! Look at that. I'll bet Bains snuffed that poor jailer and then threw the body into the river.""
				(global112 setMotion: MoveTo 170 79 self)
			)
			(2
				(User canControl: 1)
				(localproc_2 62 3) ; "You take care of the evidence, and I'll go radio a request for the dive team."
				(= global187 1)
				(global112 setMotion: MoveTo 345 79 self)
				(= global212 2)
				(HandsOn)
			)
			(3
				(= global212 0)
			)
		)
	)
)

(instance thereHeIs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(diver
					view: 22
					setCycle: Walk
					setStep: 3 2
					posn: 260 100
					init:
					setMotion: MoveTo 154 100 self
				)
				(= global212 3)
				(gEgo posn: 292 (gEgo y:) setMotion: MoveTo 186 100)
			)
			(1
				(tmpSound number: 12 loop: 1 play: 1)
				(if (< global110 30)
					(diver stopUpd:)
				else
					(diver setMotion: Follow gEgo 600)
				)
				(localproc_2 62 4 83) ; "Well, there he is," grunts Officer Moore. "I found him wedged in some rocks."
				(localproc_2 62 5 83) ; "It's not a pretty sight, eh, Sonny?"
				(= local104 1)
				(HandsOn)
			)
		)
	)
)

(instance rm62 of Rm
	(properties
		picture 62
		style 0
	)

	(method (init)
		(super init:)
		(self setLocales: 153 155)
		(NormalEgo)
		(HandsOn)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(if global188
			(Load rsVIEW 14)
			(Load rsVIEW 76)
			(Load rsVIEW 94)
		)
		(= global211 0)
		(= global212
			(cond
				(global188 0)
				((gCast contains: global112) 2)
				((gCast contains: diver) 3)
				(else 1)
			)
		)
		(if (and (== global100 5) (not global188))
			(if (== (gEgo view:) 17)
				(gContinuousMusic number: 12 loop: 1 play:)
			else
				(gContinuousMusic number: 3 loop: -1 play:)
			)
		)
		(gEgo
			setStep: 3 2
			posn: 300 (gEgo y:)
			setCycle: Walk
			illegalBits: $8000
			ignoreActors: 0
			setPri: -1
			setLoop: -1
			init:
		)
		(if (>= global111 3)
			(if global184
				((View new:)
					view: 93
					loop: 0
					cel: 0
					posn: 115 82
					init:
					addToPic:
				)
			)
			(gEgo observeBlocks: bloodBlock)
			(blood
				view: 93
				loop: 1
				cel: 2
				posn: 84 86
				init:
				ignoreActors:
				addToPic:
			)
			(bloodView view: 93 loop: 0 cel: 2 posn: 0 -10 setPri: 15 init:)
			(if (and (== gPrevRoomNum 60) (!= global189 13))
				(gEgo setMotion: MoveTo -10 (gEgo y:))
				(User prevDir: 7)
			)
			(if global188
				(bains
					view: 14
					setStep: 12 5
					posn: 94 140
					setCycle: Walk
					init:
					illegalBits: 0
					setScript: bainsScript
				)
			)
			(if (== global131 13)
				((= global112 (Act new:))
					view: 20
					setStep: 3 2
					posn: 330 79
					setAvoider: (Avoid new:)
					setCycle: Walk
					setMotion: 0
					init:
					stopUpd:
				)
			)
			(switch global189
				(14
					(diver
						view: 22
						posn: 170 90
						setMotion: Follow gEgo 600
						init:
					)
					(if (< global110 30)
						(diver setLoop: 1 stopUpd:)
					)
					(localproc_2 62 6 83) ; ""Did you forget something, Sonny?" Officer Moore asks."
				)
				(13
					(self setScript: thereHeIs)
				)
				(15
					(gEgo
						view: 17
						setCycle: Walk
						setStep: 3 2
						illegalBits: $8000
						ignoreActors: 0
						posn: 164 81
					)
					(diver
						view: 22
						posn: 206 84
						setMotion: Follow gEgo 600
						init:
					)
					(if (< global110 30)
						(diver setLoop: 1 stopUpd:)
					)
					(localproc_2 62 5 83) ; "It's not a pretty sight, eh, Sonny?"
					(= local104 1)
				)
				(16
					(gEgo
						view: 17
						setCycle: Walk
						setStep: 3 2
						illegalBits: $8000
						ignoreActors: 0
						posn: 200 90
						setMotion: MoveTo 340 90
					)
					(localproc_2 62 7 83) ; "It looks as though Officer Moore has decided to stay down a little longer."
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(local106 0)
			((< (gEgo x:) 4)
				(gEgo x: 4)
			)
			((> (gEgo y:) 205)
				(if (Random 0 1)
					(Print 62 8) ; "It's a long walk to anywhere, Sonny."
				else
					(Print 62 9) ; "Even the squirrels around here know not to go into the street."
				)
				(gEgo setMotion: MoveTo (gEgo x:) 176)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(gCurRoom newRoom: 60)
			)
			(
				(and
					(> (gEgo x:) 290)
					global184
					(!= global189 14)
					(gCast contains: diver)
				)
				(= global189 14)
				(localproc_1 62 10) ; "See ya, Sonny!" Officer Moore shouts after you. "I'll stay here with the body."
			)
			((and local105 (not (gEgo inRect: 58 70 135 100)))
				(= local105 0)
				(bloodView posn: 0 -10 forceUpd:)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(= temp0 (event message:))
				(if
					(and
						(== (gEgo view:) 17)
						(or (== temp0 KEY_F6) (== temp0 KEY_F8) (== temp0 KEY_F10))
					)
					(localproc_1 62 11) ; "You didn't go scuba diving with your gun."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			(evSAID
				(if (Said 'call/coroner')
					(cond
						(global184
							(Print 62 12) ; "Officer Moore says, "Talk to Gelepsi, I'm staying here.""
						)
						(
							(and
								(gCast contains: global112)
								(global112 onControl:)
							)
							(Print 62 13) ; "Keith says, "Let's find a body first!""
						)
						(else
							(Print 62 14) ; "There is no need to call the coroner."
						)
					)
				)
				(if (>= global111 3)
					(cond
						((Said 'check,look/air,gauge,equipment')
							(if (!= (gEgo view:) 17)
								(Print 62 15) ; "You don't have any scuba equipment."
							else
								(Print 62 16) ; "Your tank of air is exhausted, and so are you."
							)
						)
						((Said 'yes')
							(if local104
								(= local104 0)
								(cond
									((== global189 14)
										(Print 62 17) ; "Yeah, maybe you overlooked some evidence."
									)
									(global184
										(Print 62 18) ; "Officer Moore looks at you in disgust. "Yeah, to a homicide dick like you, it's just one more dead body.""
									)
								)
							else
								(event claimed: 0)
							)
						)
						((Said 'no')
							(if local104
								(= local104 0)
								(cond
									((== global189 14)
										(Print 62 19) ; "I'm glad you came back anyway. Baby-sitting a corpse isn't my idea of a good time."
									)
									(global184
										(Print 62 20) ; "Yeah, even though you're working homicide, you're still human, Sonny."
									)
								)
							else
								(event claimed: 0)
							)
						)
						(
							(or
								(Said 'dust,powder[/can]')
								(Said '(apply,use)<dust,powder[/can]')
								(Said
									'get,remove,hoist/fingerprint,print[<finger]'
								)
							)
							(if (localproc_0)
								(if (gEgo inRect: 248 97 293 121)
									(global122 startUpd: setPri: 0)
									(localproc_2 62 21 83) ; "First, you apply the fingerprint powder."
									(global122 setPri: 15 stopUpd:)
									(global120 startUpd: setPri: 0)
									(localproc_2 62 22 83) ; "You brush the powder away, but the garbage can is "clean". There are no useful prints."
									(global120 setPri: 14 stopUpd:)
								else
									(localproc_1 62 23) ; "Where you're standing, there's nothing to fingerprint."
								)
							)
						)
						((or (Said 'use/camera') (Said 'get/painting'))
							(if (localproc_0)
								(global124 startUpd: setPri: 0)
								(SetScore 1 72)
								(localproc_1 62 24 83) ; "You photograph the crime scene from several different angles. Then you return the camera to the field kit."
								(global124 setPri: 14 stopUpd:)
							)
						)
						((gEgo inRect: 58 70 135 100)
							(cond
								((Said 'check,feel/sign,breathing')
									(localproc_2 62 25) ; "The man is dead. There can be no doubt."
								)
								(
									(or
										(Said 'get,remove,pick/blood')
										(Said 'get,remove,pick/sample<blood')
										(Said 'get,pick/sample/blood')
										(Said 'use/dropper,vial')
										(Said 'drop/blood/vial')
									)
									(if (localproc_0)
										(if (IsFlag 144)
											(localproc_2 62 26) ; "You have already collected a sample of this blood."
										else
											(global119 startUpd: setPri: 0)
											(global118 startUpd: setPri: 0)
											(SetScore 2)
											(localproc_2 62 27 83) ; "You use the eye dropper to collect a sample of the coagulated blood and put it into the glass vial."
											(gEgo get: 28) ; vial_of_blood
											(SetFlag 144)
											(global119 setPri: 13 stopUpd:)
											(Print 62 28 #draw) ; "You return the eye dropper to the kit, and add the vial of blood to your inventory of evidence."
											(if
												(and
													(== global131 13)
													(== global189 0)
												)
												(rm62 setScript: keithAmbles)
											)
										)
									)
								)
								(
									(or
										(Said 'make,use/plaster,cast')
										(Said
											'get,cast/(print<feet),footprint,print,(sample<(print<feet),footprint)'
										)
									)
									(if (localproc_0)
										(if (gEgo has: 17) ; plaster_cast
											(localproc_2 62 29) ; "You have already taken a cast of the footprint, and there's not enough casting plaster for another."
										else
											(global125 startUpd: setPri: 0)
											(localproc_2 62 30 83) ; "You remove the box of casting powder."
											(localproc_2 62 31) ; "You mix the powder to the proper consistency and pour it into the footprint depression."
											(gEgo get: 17) ; plaster_cast
											(SetScore 2)
											(global125 setPri: 13 stopUpd:)
											(localproc_2 62 32 83) ; "After the liquid dries, you remove the impression of the footprint and add it to the list of evidence."
											(if
												(and
													(== global131 13)
													(== global189 0)
												)
												(rm62 setScript: keithAmbles)
											)
										)
									)
								)
								(
									(or
										(Said 'use,get,remove/baggie')
										(Said 'get,get/hair,dirt,rock')
									)
									(if (localproc_0)
										(localproc_1 62 33) ; "Looking around carefully, you decide there's nothing worth using your only plastic baggy on."
									)
								)
								(global184
									(cond
										((Said 'throw[<back]/body')
											(localproc_2 62 34) ; "MERCY! Leave the poor guy where he is!"
										)
										((Said 'frisk,look/body,luis,body')
											(localproc_2 62 35) ; "You view the victim's body and see what appears to be a bullet hole in the head and superficial cuts and scratches on the throat."
										)
										((Said 'look,view/injury,hole,head')
											(localproc_2 62 36) ; "The hair and skin around the bullet hole have powder burns, indicating that the gun was very close to the victim's head."
										)
										((Said 'look,view/scratch,neck')
											(localproc_2 62 37) ; "The scratches on the victim's neck raise the possibility that the victim struggled with his killer."
										)
										(
											(Said
												'frisk,look/panties,cloth,arm,leg,feet,hand,toe,finger'
											)
											(localproc_2 62 38) ; "Looking at that yields no further clues."
										)
										((Said '/clock')
											(localproc_2 62 39) ; "Unlike its owner, the young man's watch is still ticking."
										)
									)
								)
								(
									(and
										(not global184)
										(Said
											'look,look,frisk,get,view/body,injury,scratch,neck'
										)
									)
									(Print 62 40) ; "It's not here."
								)
							)
						)
						(
							(and
								global184
								(Said
									'look,look,frisk,view/body,body,luis,injury,scratch,neck'
								)
							)
							(proc0_7) ; "You're not close enough."
						)
						(
							(and
								(not global184)
								(Said
									'look,view,frisk/body,body,luis,injury,neck'
								)
							)
							(Print 62 40) ; "It's not here."
						)
					)
				)
				(cond
					((Said 'dive')
						(if (!= (gEgo view:) 17)
							(Print 62 41) ; "You need scuba equipment to go diving."
						else
							(Print 62 16) ; "Your tank of air is exhausted, and so are you."
						)
					)
					((Said 'get,remove/garbage')
						(if (gEgo inRect: 248 97 293 121)
							(localproc_2 62 42) ; "YUK!"
						else
							(localproc_1 62 43) ; "You're not close enough."
						)
					)
					((Said 'frisk,move,dig,(look<(through,below))/can,garbage')
						(if (gEgo inRect: 248 97 293 121)
							(if
								(and
									(== ((gInventory at: 26) owner:) 62) ; jail_clothes
									(>= global111 3)
								)
								(localproc_2 62 44) ; "Moving the garbage around, you find discarded clothing. Looking closer, you see what appears to be spots of blood on the clothes."
								(= local102 1)
							else
								(localproc_2 62 45) ; "You move the garbage around, but all you see is more garbage."
							)
						else
							(localproc_1 62 43) ; "You're not close enough."
						)
					)
					((Said 'move,get,hoist/can[<garbage]')
						(if (gEgo inRect: 248 97 293 121)
							(localproc_2 62 46) ; "Moving the garbage can wouldn't help you.!"
						else
							(localproc_1 62 43) ; "You're not close enough."
						)
					)
					((Said 'smell')
						(if (gEgo inRect: 248 97 293 121)
							(localproc_2 62 47) ; "Sheeeeeoooooo! What an aroma!"
						else
							(localproc_1 62 48) ; "You take a snoot-full of fresh air; NO cigarette smoke!"
						)
					)
					((Said 'get/cloth')
						(cond
							((not (IsItemAt 26)) ; jail_clothes
								(Print 62 49) ; "You already took the clothes."
							)
							((gEgo inRect: 248 97 293 121)
								(if (and local102 (IsItemAt 26)) ; jail_clothes
									(SetScore 1)
									(localproc_2 62 50) ; "You remove a pair of grey pants and a blue shirt from the can."
									(localproc_2 62 51) ; "You think to yourself, "Man, these look like jail clothes....wait a minute! Here's a cloth nametag sewn onto the shirt.""
									(gEgo get: 26) ; jail_clothes
								else
									(localproc_1 62 52) ; "What clothes? You don't see any here."
								)
							)
							(else
								(localproc_1 62 43) ; "You're not close enough."
							)
						)
					)
					((Said 'get/clue')
						(if (and local103 (gEgo inRect: 58 70 135 100))
							(localproc_2 62 53) ; "Having reasonable cause to believe a serious crime may have been committed, you need to gather and preserve evidence. Items in the "field kit" will aid you."
						)
					)
					((and (Said 'talk,ask/diver') (gCast contains: diver))
						(if (< (gEgo distanceTo: diver) 60)
							(localproc_2 62 54) ; "Officer Moore says, "Poor guy. He's just a few years older than my kid.""
						else
							(localproc_1 62 55) ; "He can't hear you."
						)
					)
					((Said 'look/diver')
						(if (gCast contains: diver)
							(localproc_1 62 56) ; "Officer Moore is still in his scuba equipment."
						else
							(localproc_1 62 57) ; "He's not here."
						)
					)
					((Said 'look,read/name,label')
						(if (gEgo has: 26) ; jail_clothes
							(SetScore 2 73)
							(localproc_2 62 58) ; "J BAINS"
						else
							(proc0_9) ; "You don't have it."
						)
					)
					((Said 'get,make/sample,cast')
						(Print 62 59) ; "Please be more specific."
					)
					((Said 'look>')
						(cond
							((Said '/briefcase')
								(event claimed: 0)
							)
							(
								(or
									(Said '/(print<feet)')
									(Said '/mark,dirt,footprint,clue,blood')
									(Said '<down')
								)
								(if
									(and
										(gEgo inRect: 58 70 135 100)
										(>= global111 3)
									)
									(bloodView posn: 39 107 forceUpd:)
									(= local105 1)
									(SetScore 1 71)
									(localproc_2 62 60 83) ; "Near the river's edge, you look down and see what appear to be partially coagulated blood and drag marks."
									(localproc_2 62 61) ; "You also see footprints in the soft, damp ground."
									(if (and (== global131 13) (== global189 0))
										(rm62 setScript: keithAmbles)
									)
								else
									(localproc_1 62 62) ; "You see nothing but dirt, grass, and ants."
								)
							)
							((Said '/auto')
								(if (and (gCast contains: car) (not local100))
									(Print 62 63) ; "Watch out! A car can be a deadly weapon, too."
								else
									(Print 62 64) ; "What car?"
								)
							)
							((Said '/plate')
								(if (and (gCast contains: car) (not local100))
									(Print 62 65) ; "All you can make out is "C03"."
								else
									(Print 62 66) ; "What license plate?"
								)
							)
							((or (Said '/garbage') (Said '/can[<garbage]'))
								(if (gEgo inRect: 248 97 293 121)
									(localproc_2 62 67) ; "As you suspected, you look in the garbage can and find..."
									(localproc_2 62 68) ; "GARBAGE!"
								else
									(localproc_1 62 43) ; "You're not close enough."
								)
							)
							((Said '/sample[<blood]')
								(if (IsFlag 144)
									((gInventory at: 28) showSelf:) ; vial_of_blood
								else
									(proc0_9) ; "You don't have it."
								)
							)
							((Said '/tree<behind')
								(localproc_1 62 69) ; "You look, but find nothing behind the tree."
							)
							((Said '/bush<below')
								(localproc_1 62 70) ; "You look, but find nothing under the bush."
							)
							((Said '/tree')
								(localproc_1 62 71) ; "The trees here appear to be a variety of cottonwood."
							)
							((Said '[<at,around][/!*,cove,area]')
								(localproc_1 62 72) ; "You're in Cotton Cove. You remember the carefree days of your youth, when you played cops and robbers here. Now, however, it's very real...and much more serious."
							)
						)
					)
				)
			)
		)
	)
)

(instance bainsScript of Script
	(properties)

	(method (init)
		(super init:)
		(if global188
			(car
				view: 94
				setStep: 16 4
				setLoop: 1
				setCel: 0
				posn: 3 201
				init:
				illegalBits: 0
				ignoreActors:
				stopUpd:
			)
			(smoke view: 94 loop: 2 cel: 0 init: ignoreActors: stopUpd:)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(< 17 (- (gEgo x:) (car x:)) 65)
				(> 14 (- (car y:) (gEgo y:)))
				(< (self state:) 5)
			)
			(self changeState: 5)
		)
		(if (!= (self state:) 4)
			(smoke posn: (- (car x:) 48) (+ (car y:) 6))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bains setMotion: MoveTo -26 140 self)
			)
			(1
				(bains stopUpd:)
				(= seconds 3)
			)
			(2
				(tmpSound number: 39 loop: 1 play:)
				(= global188 0)
				(car
					setMotion:
						MoveTo
						(gEgo x:)
						(if (> (gEgo y:) 132)
							(+ (gEgo y:) 10)
						else
							141
						)
						self
				)
				(smoke setCycle: Fwd)
			)
			(3
				(car setMotion: MoveTo 430 (car y:) self)
			)
			(4
				(car stopUpd:)
				(smoke stopUpd:)
				(= local100 1)
			)
			(5
				(car setMotion: MoveTo 430 (+ (gEgo y:) 28))
				(if (== global131 13)
					(global112 setMotion: Follow gEgo 50 startUpd:)
				)
				((= local101 (Act new:))
					view: 76
					posn: (gEgo x:) (gEgo y:)
					loop: 5
					cel: 0
					setMotion: 0
					cycleSpeed: 2
					init:
					setCycle: End self
				)
				(gEgo dispose:)
				(= local106 1)
			)
			(6
				(local101
					setLoop: 6
					cel: 0
					setMotion: MoveTo (+ (local101 x:) 20) (local101 y:)
					setCycle: End self
				)
			)
			(7
				(local101 setLoop: 7 setCel: 0 stopUpd: addToPic:)
				(= seconds 2)
				(User canInput: 0)
			)
			(8
				(if (== global131 13)
					(global112 loop: 1)
					(localproc_1 62 73 83) ; "Gee, Sonny, did YOU see THAT?!" gasps Keith. "Sonny. Sonny? SONNY!?"
				)
				(= seconds 2)
			)
			(9
				(Print 62 74 #mode 1) ; "Thank you for playing Police Quest 2."
				(if (== global131 13)
					(EgoDead
						{Don't worry, though; Keith will explain in his report how he heroically 'watched your back'. }
					)
				else
					(EgoDead
						{Too bad, soooo sad. There were no witnesses to your untimely demise. But don't worry. Just restore and try again. }
					)
				)
			)
		)
	)
)

