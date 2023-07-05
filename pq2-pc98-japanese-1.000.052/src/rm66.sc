;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 66)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm66 0
)

(synonyms
	(mask glasses)
	(bottle tank)
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
	local107
	local108
	local109
	local110
	local111
	local112
	local113
)

(instance rm66 of Rm
	(properties
		picture 666
		style 2
	)

	(method (init)
		(Load rsVIEW 96)
		(Load rsVIEW 161)
		(super init:)
		(self setLocales: 153)
		(HandsOff)
		(User canInput: 1)
		((= local110 (View new:))
			view: 96
			loop: 2
			cel: (if (not (== local102 3)) 3 else 4)
			posn: 112 101
			init:
			stopUpd:
		)
		((= local108 (View new:))
			view: 96
			loop: 2
			cel: (if (not (== local102 1)) 1 else 4)
			posn: 133 101
			init:
			stopUpd:
		)
		((= local109 (View new:))
			view: 96
			loop: 2
			cel: (if (not (== local102 2)) 2 else 4)
			posn: 154 101
			init:
			stopUpd:
		)
		((= local103 (View new:))
			view: 96
			loop: 0
			cel: 0
			posn: 106 149
			init:
			stopUpd:
		)
		((= local104 (View new:))
			view: 96
			loop: 3
			cel: 0
			posn: 76 132
			init:
			stopUpd:
		)
		((= local105 (View new:))
			view: 96
			loop: 0
			cel: 1
			posn: 210 125
			init:
			stopUpd:
		)
		((= local106 (View new:))
			view: 96
			loop: 1
			cel: 0
			posn: 141 134
			init:
			stopUpd:
		)
		((= local107 (View new:))
			view: 96
			loop: 1
			cel: 2
			setPri: 14
			posn: 228 139
			init:
			stopUpd:
		)
		((View new:) view: 96 loop: 1 cel: 1 posn: 194 144 init: addToPic:)
		((= local111 (View new:))
			view: 96
			loop: 2
			cel: 0
			posn: 175 101
			init:
			stopUpd:
		)
		((View new:)
			view: 96
			loop: 2
			cel: 4
			posn: 196 101
			setPri: 8
			init:
			stopUpd:
			addToPic:
		)
		(self setScript: rm66Script)
	)
)

(instance rm66Script of Script
	(properties)

	(method (doit)
		(if (> local113 1)
			(-- local113)
		)
		(if (== local113 1)
			(= local113 0)
			(airScript changeState: 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(Print 66 0 #at -1 20) ; "Before exiting, you put on some scuba equipment, and you leave everything else you have in the van."
				(for ((= local100 0)) (<= local100 37) ((++ local100))
					(if (gEgo has: local100)
						(PutItem local100)
					)
				)
				(if (== global190 local102)
					(= global191 2200)
				else
					(= global191 (+ 243 (* 13 local102)))
				)
				(gCurRoom newRoom: 60)
			)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 100])
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (= temp0 (event message:)) KEY_F6)
						(== temp0 KEY_F8)
						(== temp0 KEY_F10)
					)
					(Print 66 1) ; "Calm down. You have no need of your gun here."
					(event claimed: 1)
				)
			)
			(evSAID
				(cond
					(
						(Said
							'[check,frisk,look]/air,pressure,(supply[<air]),(bottle[<air]),(gauge[<air,pressure])'
						)
						(if (IsFlag 3)
							(airScript changeState: 0)
						else
							(Print 66 2 #at -1 155) ; "Choose one of the tanks first."
						)
					)
					((Said 'look>')
						(cond
							((Said '[<around,in,in][/van,chamber,equipment]')
								(Print 66 3 #at -1 155) ; "In the van are various items used for diving."
								(Print 66 4) ; "some yellow air tanks"
								(Print 66 5) ; "one gray tank"
								(or (IsFlag 4) (Print 66 6)) ; "a wet suit"
								(or (IsFlag 6) (Print 66 7)) ; "a weight belt"
								(or (IsFlag 7) (Print 66 8)) ; "a buoyancy control vest"
								(or (IsFlag 8) (Print 66 9)) ; "a scuba mask"
								(Print 66 10) ; "and fins"
							)
							(
								(or
									(Said '/wall,bracket')
									(Said '/bottle[<yellow]')
									(Said '/bottle[<gray,ash]')
									(Said '/bottle[<scuba]')
								)
								(Print 66 11 #at -1 155) ; "The tanks contain compressed air used for scuba diving."
								(Print 66 12) ; "You may choose one of the yellow tanks. Which would you like; number 1, 2, or 3?"
							)
							((Said '/belt[<weight]')
								(Print 66 13 #at -1 155) ; "It is made of sturdy material and filled with lead weights. It is used to overcome bouyancy."
							)
							(
								(or
									(Said '/bcv[<buoyancy]')
									(Said '/bcv<control<buoyancy')
								)
								(Print 66 14 #at -1 155) ; "You can inflate it (from your tank) or deflate it to control your depth."
							)
							((Said '/fin')
								(Print 66 15 #at -1 155) ; "They help you to swim like a fish."
							)
							((Said '/mask,japanesemask')
								(Print 66 16 #at -1 10) ; "It's made of black rubber with a shatterproof glass faceplate. It's invaluable for keeping water and debris out of your eyes."
							)
							((Said '/suit')
								(Print 66 17) ; "The wet suit is made of thick rubber. It provides buoyancy and insulation."
							)
							((Said '/pane,out')
								(Print 66 18) ; "Looking out the window reminds you that Officer Moore is waiting for you."
							)
						)
					)
					((Said 'get/bottle[<yellow,air]')
						(if local112
							(Print 66 19 #at -1 155) ; "Which one?"
						else
							(Print 66 12 #at -1 155) ; "You may choose one of the yellow tanks. Which would you like; number 1, 2, or 3?"
							(= local112 1)
						)
					)
					((or (Said '[get]/1') (Said '[get]/bottle<1'))
						(if (IsFlag 3)
							(if (== local102 1)
								(Print 66 20 #at -1 155) ; "You already have that tank."
							else
								(Print 66 21 #at -1 155) ; "You can only use one tank at a time."
							)
						else
							(Print 66 22 #at -1 155) ; "You remove the air tank from the back of the van."
							(SetFlag 3)
							(local108 setCel: 4)
							(= local102 1)
						)
					)
					((or (Said '[get]/2') (Said '[get]/bottle<2'))
						(if (IsFlag 3)
							(if (== local102 2)
								(Print 66 20 #at -1 155) ; "You already have that tank."
							else
								(Print 66 21 #at -1 155) ; "You can only use one tank at a time."
							)
						else
							(Print 66 22 #at -1 155) ; "You remove the air tank from the back of the van."
							(SetFlag 3)
							(local109 setCel: 4)
							(= local102 2)
						)
					)
					((or (Said '[get]/3') (Said '[get]/bottle<3'))
						(if (IsFlag 3)
							(if (== local102 3)
								(Print 66 20 #at -1 155) ; "You already have that tank."
							else
								(Print 66 21 #at -1 155) ; "You can only use one tank at a time."
							)
						else
							(Print 66 22 #at -1 155) ; "You remove the air tank from the back of the van."
							(SetFlag 3)
							(local110 setCel: 4)
							(= local102 3)
						)
					)
					(
						(or
							(Said 'get/bottle<gray,ash')
							(Said '[get]/bottle<4')
							(Said '[get]/4')
						)
						(local111 startUpd: cel: 4)
						(Print 66 23 #at -1 140 #draw) ; "You take the grey tank from its brackets, but decide that it is much too large for river diving, and you return it."
						(local111 cel: 0 stopUpd:)
					)
					((Said 'get/belt[<weight]')
						(if (IsFlag 6)
							(Print 66 24 #at -1 155) ; "You already took that item."
						else
							(Print 66 25 #at -1 155) ; "You take the weight belt."
							(local103 hide:)
							(SetFlag 6)
						)
					)
					((Said 'get/mask,japanesemask')
						(if (IsFlag 8)
							(Print 66 24 #at -1 155) ; "You already took that item."
						else
							(Print 66 26 #at -1 155) ; "You take the diving mask."
							(local106 hide:)
							(SetFlag 8)
						)
					)
					((Said 'get/fin>')
						(cond
							((IsFlag 5)
								(if (Said 'get/fin<yellow')
									(Print 66 24 #at -1 155) ; "You already took that item."
								else
									(Print 66 27) ; "The black pair of fins are too small for you."
								)
							)
							((Said 'get/fin<black')
								(Print 66 27) ; "The black pair of fins are too small for you."
							)
							(else
								(Print 66 28 #at -1 155) ; "You take the pair of yellow fins."
								(local107 hide:)
								(SetFlag 5)
							)
						)
						(event claimed: 1)
					)
					(
						(or
							(Said 'get/suit<wet')
							(Said 'get/suit[<scuba]')
							(Said 'get/suit[<dive]')
							(Said 'change,japanesechange,(get<off)/cloth')
							(Said 'change,japanesechange<in[/suit]')
						)
						(if (IsFlag 4)
							(Print 66 29 #at -1 155) ; "You've already changed into the wet suit."
						else
							(Print 66 30 #at -1 155) ; "You take the wet suit, and change into it."
							(local105 hide:)
							(SetFlag 4)
						)
					)
					(
						(or
							(Said 'get/bcv<control<buoyancy')
							(Said 'get/bcv[<buoyancy]')
						)
						(if (IsFlag 7)
							(Print 66 24 #at -1 155) ; "You already took that item."
						else
							(Print 66 31 #at -1 155) ; "You take one buoyancy control vest."
							(local104 hide:)
							(SetFlag 7)
						)
					)
					(
						(or
							(Said 'exit,japaneseclimbdown[/van]')
							(Said '(get<out),exit[/van]')
							(Said 'open/door,japanesedoor')
							(Said 'swim,dive[<go]')
						)
						(self changeState: 1)
					)
					((Said 'get[/equipment,crud]')
						(Print 66 32) ; "Be more specific, please."
					)
					((Said '(drop,japaneseput<on),wear')
						(Print 66 33) ; "First, take everything you'll need, then leave the van."
					)
					(
						(Said
							'replace,japanesereplace,drop,japaneseput/bottle,1,2,3'
						)
						(if local102
							(switch local102
								(1
									(local108 cel: 1 forceUpd:)
								)
								(2
									(local109 cel: 2 forceUpd:)
								)
								(3
									(local110 cel: 3 forceUpd:)
								)
							)
							(Print 66 34 #at -1 155) ; "You put the tank back into its wall brackets."
							(= local102 0)
							(ClearFlag 3)
							(= local113 1)
						else
							(Print 66 35 #at -1 155) ; "You don't have a tank to put back."
						)
					)
					(
						(Said
							'replace,japanesereplace,drop,japaneseput/bcv,suit,fin,mask,japanesemask,belt'
						)
						(Print 66 36) ; "Keep it: you'll need it to go diving."
					)
				)
			)
		)
	)
)

(instance airScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global190 local102)
					(= global191 2200)
					(SetScore 2 74)
				else
					(= global191 (+ 243 (* 13 local102)))
				)
				(DrawCel 161 0 0 262 62 15)
				(Format @local0 66 37 global191) ; "%u"
				(Display @local0 dsCOORD 277 76 dsCOLOR 14 dsBACKGROUND 1)
				(= local113 300)
			)
			(1
				(DrawCel 161 0 2 262 62 15)
				(Display @local0 dsCOORD 277 76 dsCOLOR 0 dsBACKGROUND 0)
			)
		)
	)
)

