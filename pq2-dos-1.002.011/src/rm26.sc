;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm26 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance keithAct of Act
	(properties)
)

(instance rm26 of Rm
	(properties
		picture 26
		style 4
	)

	(method (dispose)
		(gContinuousMusic fade:)
		(super dispose:)
	)

	(method (init)
		(++ global172)
		(if (== gPrevRoomNum 0)
			(= gPrevRoomNum 13)
			(= global131 13)
			(= global100 12)
			(gEgo get: 0 1 2 3 10) ; hand_gun
		)
		(User canInput: 1 canControl: 1)
		(= local3 0)
		(Load rsVIEW 252)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 20)
		(Load rsVIEW 129)
		(super init:)
		(self setLocales: 153)
		(= global211 0)
		(= global212 3)
		((View new:)
			view: 252
			posn: 132 121
			loop: 1
			cel: 0
			setPri: 8
			init:
			stopUpd:
			ignoreActors: 0
		)
		((View new:)
			view: 252
			posn: 206 62
			loop: 0
			cel: 5
			ignoreActors:
			setPri: 0
			init:
			stopUpd:
		)
		((View new:)
			view: 252
			posn: 210 109
			loop: 0
			cel: 1
			setPri: 7
			init:
			stopUpd:
			ignoreActors: 0
		)
		((View new:)
			view: 252
			posn: 60 119
			loop: 0
			cel: 2
			setPri: 8
			init:
			stopUpd:
			ignoreActors: 0
		)
		((View new:)
			view: 252
			posn: 230 76
			loop: 0
			cel: 4
			setPri: 5
			init:
			stopUpd:
			ignoreActors: 0
		)
		((View new:)
			view: 252
			posn: 139 75
			loop: 0
			cel: 3
			setPri: 6
			init:
			stopUpd:
			ignoreActors: 0
		)
		(gEgo
			view: (if global204 6 else 0)
			loop: 1
			cel: 0
			posn: 220 170
			setPri: 0
			startUpd:
			illegalBits: $8000
			init:
		)
		(if (== global131 13)
			((= global112 keithAct)
				view: 20
				loop: 3
				cel: 0
				posn: 220 180
				setPri: 0
				setCycle: Walk
				setMotion: Follow gEgo 500
				illegalBits: $8000
				init:
			)
		else
			(= global112 0)
		)
		(if (not (IsFlag 0))
			((= local1 (View new:))
				view: 252
				posn: 202 119
				loop: 0
				cel: 0
				setPri: 7
				init:
				ignoreActors: 1
				stopUpd:
			)
			(self setScript: keithSpeak)
		else
			(self setScript: egoEnter)
		)
	)

	(method (doit)
		(if (gEgo inRect: 113 91 182 95)
			(= local0 1)
		else
			(= local0 0)
		)
		(super doit:)
		(cond
			((and (!= (mod (gEgo view:) 2) 0) (<= (gEgo y:) 100))
				(gEgo view: (- (gEgo view:) 1))
			)
			((and (!= (mod (gEgo view:) 2) 1) (> (gEgo y:) 100))
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(if (> local4 1)
			(-- local4)
		)
		(if (not script)
			(if (>= (gEgo y:) 128)
				(if local4
					(= local4 1)
				else
					(self newRoom: 25)
				)
			)
			(if (and (== local4 1) (not local0))
				(self setScript: keithBack)
				(= local4 0)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '[get]/shit')
						(if local0
							(Print 26 0 #at -1 20) ; "You don't have time."
						else
							(Print 26 1 #at -1 20) ; "You are not in the bathroom."
						)
					)
					((or (Said 'leak') (Said 'get/leak'))
						(if local0
							(Print 26 2 #at -1 20) ; ""Whew!" you sigh."
							(Print 26 3 #at -1 20) ; "You take time out for a natural body function."
						else
							(Print 26 1 #at -1 20) ; "You are not in the bathroom."
						)
					)
					((Said 'flush/crapper')
						(if local0
							(Print 26 4 #at -1 20) ; "Whooooooooosssssshhhhh........ gurgle, gurgle."
						else
							(Print 26 1 #at -1 20) ; "You are not in the bathroom."
						)
					)
					((Said 'bath[/hand]')
						(if local0
							(Print 26 5 #at -1 20) ; "You wash and dry your hands."
						else
							(Print 26 1 #at -1 20) ; "You are not in the bathroom."
						)
					)
					((Said 'get/card')
						(if local0
							(if (not (IsItemAt 35)) ; Colby_s_business_card
								(Print 26 6) ; "You already picked up a business card from the sink."
							else
								(= local3 1)
								(Print 26 7 #at -1 20) ; "You pick up the card."
								(gEgo get: 35) ; Colby_s_business_card
								(SetScore 3)
							)
						else
							(Print 26 8 #at -1 20) ; "There is no card here."
						)
					)
					((Said 'read,open/letter,envelope')
						(if (gEgo has: 25) ; envelope
							(Print 26 9 #at -1 130) ; "After reading the letter, you ponder its contents and think..."
							(Print 26 10 #icon 125) ; "Bains mailed the letter hoping to suck Roberts in by offering him a business deal. Roberts fell for it and responded to the letter. He came to the motel room, where Bains killed him in cold blood."
							(SetScore 2 89)
						else
							(Print 26 11 #at -1 130) ; "You don't have a letter."
						)
					)
					((Said 'read,look/card')
						(if (not (gEgo has: 35)) ; Colby_s_business_card
							(event claimed: 0)
						else
							((gInventory at: 35) showSelf:) ; Colby_s_business_card
						)
					)
					(
						(or
							(Said 'turn/card')
							(Said 'look<back/card')
							(Said 'look/back/card')
						)
						(if (not (gEgo has: 35)) ; Colby_s_business_card
							(event claimed: 0)
						else
							(Print 26 12) ; "The back of the card is blank."
						)
					)
					((Said 'look>')
						(cond
							((or (Said '<below/table') (Said '<below/desk'))
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 14 #at -1 130) ; "You see a pulley mounted under the table. It was part of the booby trap."
								)
							)
							((Said '/basin')
								(if local0
									(if (== local3 1)
										(Print 26 15 #at -1 130) ; "It is the tiled sink, where you picked up a business card earlier."
									else
										(Print 26 16 #at -1 130) ; "Looking at the tiled sink, you see what appears to be a business card."
									)
								else
									(Print 26 1 #at -1 20) ; "You are not in the bathroom."
								)
							)
							((Said '/mirror')
								(if local0
									(Print 26 17 #at -1 130) ; "You don't have time for self-admiration."
								else
									(Print 26 1 #at -1 20) ; "You are not in the bathroom."
								)
							)
							((Said '/crapper')
								(if local0
									(Print 26 18 #at -1 130) ; "Nothing special. It's just a normal motel toilet."
								else
									(Print 26 1 #at -1 20) ; "You are not in the bathroom."
								)
							)
							((Said '<below/bed')
								(cond
									(local0
										(Print 26 13 #at 60 20) ; "You are in the bathroom."
									)
									((not (gEgo inRect: 105 97 150 105))
										(Print 26 19 #at 60 20) ; "You can't see anything from here."
									)
									((IsItemAt 29) ; lipstick
										(Print 26 20) ; "There is a tube of lipstick under the bed."
									)
									(else
										(Print 26 21) ; "There is nothing under the bed."
									)
								)
							)
							((Said '/bed')
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 22 #at -1 20) ; "You notice that the bed is unmade."
								)
							)
							((Said '/lamp')
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 23 #at -1 20) ; "You find nothing significant about the lamp."
								)
							)
							((Said '/painting')
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 24 #at -1 130) ; "You look at the painting and think: "Not bad, for a print.""
								)
							)
							((Said '/table,desk')
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 25 #at -1 20) ; "You see nothing on top of the table."
								)
							)
							((Said '/rope,cable,(trap[<booby])')
								(Print 26 26 #at -1 130) ; "The booby trap consisted of a shotgun, cable, and pulleys. It was nearly a deadly combination."
								(Print 26 27 #at -1 130) ; "As you look at the mechanism that nearly cost you your life, you think... "BAINS, YOU HEARTLESS RAT!""
							)
							((Said '/wall')
								(Print 26 28 #at -1 20) ; "The walls are in desperate need of repainting."
							)
							((Said '/hanger')
								(Print 26 29 #at -1 130) ; "You see nothing of significance."
							)
							((or (Said '/ceiling') (Said '<up'))
								(Print 26 30 #at -1 20) ; "No clues there."
							)
							((or (Said '/floor,carpet,carpet') (Said '<down'))
								(if local0
									(Print 26 31 #at -1 20) ; "There is nothing special about the bathroom floor."
								else
									(Print 26 32 #at -1 130) ; "You look at the floor and see what appears to be a substantial amount of blood."
								)
							)
							((or (Said '/nightstand') (Said '/stand[<night]'))
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 33 #at -1 130) ; "It's a common type of motel nightstand, with a single drawer."
								)
							)
							((Said '/envelope')
								(if (gEgo has: 25) ; envelope
									(Print 26 34) ; "There is a letter inside."
								else
									(Print 26 35) ; "You don't have an envelope."
								)
							)
							((Said '/letter')
								(if (gEgo has: 25) ; envelope
									(Print 26 9 #at -1 130) ; "After reading the letter, you ponder its contents and think..."
									(Print 26 10) ; "Bains mailed the letter hoping to suck Roberts in by offering him a business deal. Roberts fell for it and responded to the letter. He came to the motel room, where Bains killed him in cold blood."
									(SetScore 2 89)
								else
									(Print 26 11 #at -1 130) ; "You don't have a letter."
								)
							)
							((Said '/name,address')
								(if (not (gEgo has: 25)) ; envelope
									(Print 26 36 #at -1 20) ; "What name? What address?"
								else
									(Print 26 37 #at -1 130) ; "The letter is addressed to Woody Roberts."
								)
							)
							((Said '/television')
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 38 #at -1 130) ; "Nothing special. Just a normal TV, chained to the wall."
								)
							)
							((Said '/bench')
								(if local0
									(Print 26 13 #at 60 20) ; "You are in the bathroom."
								else
									(Print 26 39 #at -1 130) ; "Bains must have used this chair for the booby trap....."
								)
							)
							((Said '/drawer')
								(cond
									(local0
										(Print 26 40 #at 60 20) ; "You are in the bathroom"
									)
									((gEgo inRect: 55 115 80 125)
										(if (== local2 1)
											(if (gEgo has: 25) ; envelope
												(Print 26 41) ; "You find nothing inside the drawer."
											else
												(Print 26 42 #at -1 130) ; "You look inside the drawer ..."
												(Print 26 43 #icon 125) ; "and you find an envelope with the corner torn off."
											)
										else
											(Print 26 44 #at -1 130) ; "The drawer is closed..."
										)
									)
									(else
										(Print 26 45 #at -1 20) ; "You are not close enough."
									)
								)
							)
							((Said '/blood,blood')
								(Print 26 46 #at -1 130) ; "There is a dark stain on the carpet."
							)
							((Said '/bath')
								(if local0
									(Print 26 47) ; "Normal size shower... Nothing here."
								else
									(Print 26 48) ; "You can't see it from here."
								)
							)
							((Said '[<at,around][/chamber,bathroom]')
								(if local0
									(Print 26 49 #at -1 130) ; "You look around the empty bathroom. You see typical bathroom fixtures: a sink, a toilet, a shower and a mirror."
								else
									(Print 26 50 #at -1 130) ; "You see a dark stain on the carpet."
								)
							)
						)
					)
					((Said 'get/(baton<lip),lipstick,television')
						(cond
							((gEgo has: 29) ; lipstick
								(Print 26 51) ; "You already have it."
							)
							((not (IsItemAt 29)) ; lipstick
								(Print 26 52) ; "There is no lipstick in this room."
							)
							((not (gEgo inRect: 105 97 150 105))
								(proc0_7) ; "You're not close enough."
							)
							(else
								(gEgo get: 29) ; lipstick
								(Print 26 53) ; "The label reads, Pink Rapture by Donna Lee Cosmetics. "This is the same brand that Marie uses," you think."
								(SetScore 3)
							)
						)
					)
					((Said 'turn<on/television')
						(if local0
							(Print 26 13 #at 60 20) ; "You are in the bathroom."
						else
							(Print 26 54 #at -1 20) ; "You don't have time to watch TV now."
						)
					)
					((Said 'move/blanket')
						(if (gEgo inRect: 67 85 139 122)
							(Print 26 55 #at -1 130) ; "You move it, look under it, but find nothing."
						else
							(Print 26 45 #at -1 20) ; "You are not close enough."
						)
					)
					((Said 'get/sample,blood')
						(cond
							((not (gEgo has: 10)) ; field_kit
								(Print 26 56 #at -1 20) ; "You'll need your field kit."
							)
							((IsFlag 113)
								(Print 26 57) ; "You already did."
							)
							((not (gEgo inRect: 108 108 150 126))
								(proc0_7) ; "You're not close enough."
							)
							(else
								(global119 setPri: 0)
								(global118 setPri: 0)
								(Print 26 58 #draw) ; "Using the eyedropper, you take a sample of the blood from the floor and put it into a vial."
								(SetScore 1)
								(gEgo get: 28) ; vial_of_blood
								(global119 setPri: 13)
								(SetFlag 113)
							)
						)
					)
					((Said 'open/drawer')
						(if (gEgo inRect: 55 115 80 125)
							(if (== local2 0)
								(Print 26 59 #at -1 130) ; "You open the drawer and look inside..."
								(if (gEgo has: 25) ; envelope
									(Print 26 60 #at -1 130) ; "You find nothing."
								else
									(= local2 1)
									(Print 26 61 #icon 125) ; "You find an envelope with the corner torn off."
								)
							else
								(Print 26 62) ; "The drawer is already open."
							)
						else
							(Print 26 45 #at -1 20) ; "You are not close enough."
						)
					)
					((Said 'close/drawer')
						(if (gEgo inRect: 55 115 80 125)
							(if (== local2 1)
								(Print 26 63 #at -1 130) ; "You close the drawer."
								(= local2 0)
							else
								(Print 26 64 #at -1 130) ; "The drawer is already closed."
							)
						else
							(Print 26 45 #at -1 20) ; "You are not close enough."
						)
					)
					((Said 'look,get/9mm,browning,(9mm<shot)')
						(cond
							(local0
								(Print 26 65) ; "There is no shotgun in here."
							)
							((IsFlag 0)
								(Print 26 66) ; "Keith took it to the car."
							)
							(else
								(Print 26 67) ; "You'd better leave the shotgun in place for the forensics team."
							)
						)
					)
					((Said 'get/envelope,letter')
						(if (== local2 1)
							(if (gEgo inRect: 55 115 80 125)
								(if (gEgo has: 25) ; envelope
									(Print 26 51) ; "You already have it."
								else
									(if (gEgo has: 24) ; envelope_corner
										(Print 26 68 #at -1 130) ; "As you examine the envelope, you compare it with the piece of paper found on Roberts, and..."
										(Print 26 69 #at -1 130) ; ""They match!" You also note that the envelope is addressed to Woody Roberts."
									else
										(Print 26 70) ; "Ok."
									)
									(gEgo get: 25) ; envelope
								)
							else
								(Print 26 45 #at -1 20) ; "You are not close enough."
							)
						else
							(Print 26 71 #at -1 20) ; "The drawer is not open."
						)
					)
					((or (Said 'lie') (Said 'nap') (Said 'sat'))
						(Print 26 72) ; "You don't have time for that."
					)
				)
			)
		)
	)
)

(instance egoEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 10 setMotion: MoveTo 220 118 self)
				(if global112
					(global112 setPri: 10 setMotion: MoveTo 220 122)
				)
			)
			(1
				(gEgo setPri: -1)
				(if global112
					(global112 setMotion: MoveTo 186 121 self)
				else
					(self cue:)
				)
			)
			(2
				(if global112
					(global112 setPri: -1 setMotion: Follow gEgo 500)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance keithSpeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 10 setMotion: MoveTo 220 118 self)
				(if global112
					(global112 setPri: 10 setMotion: MoveTo 220 122)
					(Print 26 73 #dispose #at -1 20) ; "Keith walks over, picks up a shotgun off the floor and says..."
				)
			)
			(1
				(gEgo loop: 1 setPri: -1)
				(if global112
					(global112 setPri: -1 setMotion: MoveTo 187 122 self)
				else
					(HandsOn)
					(client setScript: 0)
				)
			)
			(2
				(global112 setMotion: MoveTo 187 118 self)
			)
			(3
				(clr)
				(SetFlag 0)
				(Print 26 74 #draw #at -1 130) ; "Here's the little culprit, Sonny. I'll take it out to the car and run the numbers."
				(global112
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 220 122 self
				)
				(local1 dispose:)
			)
			(4
				(= global172 1)
				(global112 setPri: 10 setMotion: MoveTo 220 170 self)
			)
			(5
				(global112 posn: 340 340)
				(= local4 500)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance keithBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(global112
					ignoreActors: 0
					posn: 220 170
					setMotion: MoveTo 220 135 self
				)
			)
			(1
				(Print 26 75 #at -1 130 #width 280 #draw) ; "Keith returns and says... "That shotgun has wants on it from a local burglary." He continues..."We can contact Burglary division for more information.""
				(global112 setPri: -1 setMotion: Follow gEgo 500)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

