;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm28 0
)

(synonyms
	(body roberts)
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if (gEgo has: 10) ; field_kit
		(return 1)
	else
		(Print 28 0) ; "You have to have your field kit to do that."
		(return 0)
	)
)

(instance woodyBody of View
	(properties)
)

(instance Wnote of Act
	(properties)
)

(instance rm28 of Rm
	(properties
		picture 28
		style 0
	)

	(method (init)
		(super init:)
		(HandsOff)
		(User canInput: 1)
		(Load rsVIEW 267)
		(self setLocales: 153)
		(if (== global182 0)
			(= local0 1400)
		)
		(ClearFlag 153)
		(self setScript: trunkScript)
	)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)
)

(instance trunkScript of Script
	(properties)

	(method (doit)
		(if (> local0 1)
			(-- local0)
		)
		(if (== local0 1)
			(Print 28 1 #draw #at -1 50) ; ""The coroner is arriving, Sonny." Keith informs you."
			(self changeState: 3)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 149))
					(gContinuousMusic number: 12 loop: 1 play:)
					(SetFlag 149)
				)
				(cond
					((not (= local1 (IsFlag 9)))
						(woodyBody view: 267 cel: 0 loop: 0 posn: 155 111 init:)
					)
					((IsItemAt 6) ; death_threat
						(Wnote view: 267 cel: 0 loop: 1 posn: 165 125 init:)
					)
				)
				((View new:)
					view: 254
					loop: 0
					cel: 0
					posn: 154 139
					setPri: 15
					init:
					stopUpd:
					addToPic:
				)
				((View new:)
					view: 254
					loop: 0
					cel: 1
					posn: 156 51
					setPri: 15
					init:
					stopUpd:
					addToPic:
				)
			)
			(1
				(User canInput: 0)
				(Wnote setMotion: MoveTo 165 111 self)
			)
			(2
				(SetScore 2)
				(Wnote dispose:)
				(gEgo get: 6) ; death_threat
				((gInventory at: 6) showSelf:) ; death_threat
				(User canInput: 1)
			)
			(3
				(gCurRoom newRoom: 27)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look,frisk/trunk,bottom')
						(cond
							((not local1)
								(Print 28 2) ; "There is a dead person in the trunk."
							)
							((IsItemAt 6) ; death_threat
								(Print 28 3) ; "You find a note which had been hidden by the body."
							)
							(else
								(Print 28 4) ; "You see nothing but blood."
							)
						)
					)
					((Said 'drink/blood')
						(Print 28 5) ; "No thanks. You first."
					)
					((Said '/finger')
						(Print 28 6) ; "The dead man's fingers are stiff, indicating that he has been dead for a few hours."
					)
					((or (Said 'use/camera') (Said 'get/painting'))
						(if (localproc_0)
							(global124 forceUpd: setPri: 0)
							(SetScore 1 116)
							(Print 28 7 #draw) ; "You take pictures of the murder scene, and return the camera to the kit."
							(global124 setPri: 14)
						)
					)
					(
						(or
							(Said 'get,remove,pick/sample,blood')
							(Said 'use/dropper,vial')
							(Said 'drop/blood/vial')
						)
						(if (localproc_0)
							(if (IsFlag 143)
								(Print 28 8) ; "You have already collected a sample of this blood."
							else
								(global119 startUpd: setPri: 0)
								(global118 startUpd: setPri: 0)
								(SetScore 1)
								(Print 28 9 #draw) ; "You use an eyedropper to draw up some of the victim's blood."
								(gEgo get: 28) ; vial_of_blood
								(SetFlag 143)
								(global119 setPri: 13 stopUpd:)
								(Print 28 10 #draw) ; "You return the eye dropper to the kit, and add the vial of blood to your inventory of evidence."
							)
						)
					)
					(
						(or
							(Said 'use<(cast,plaster)')
							(Said 'make/plaster,cast')
							(Said 'get,cast/print,footprint,footprint')
						)
						(if (localproc_0)
							(Print 28 11) ; "You see no footprints worth casting."
						)
					)
					((or (Said 'use,get,remove/baggie') (Said 'get/hair,dirt'))
						(if (localproc_0)
							(Print 28 12) ; "Looking around carefully, you decide there's nothing worth using your last plastic baggy on."
						)
					)
					((Said 'look/blood')
						(Print 28 13) ; "You look at the blood, and feel a little squeamish."
					)
					((Said 'look,read/note,threat<death')
						(if (gEgo has: 6) ; death_threat
							((gInventory at: 6) showSelf:) ; death_threat
						else
							(event claimed: 0)
						)
					)
					((Said 'check/sign,breathing')
						(if local1
							(Print 28 14) ; "The body has been removed from the trunk."
						else
							(Print 28 15) ; "The man has no pulse, no breath and shows signs of having been dead for several hours."
						)
					)
					((Said 'get,remove,hoist,move/body,person,man')
						(cond
							((and (> global182 0) (not local1))
								(SetFlag 43)
								(gCurRoom newRoom: 27)
							)
							(local1
								(Print 28 16) ; "The body's already gone."
							)
							(else
								(Print 28 17) ; "That's the coroner's job. You'd better wait until he arrives."
							)
						)
					)
					((Said 'talk/gelepsi,cop,cop')
						(Print 28 18) ; ""Howa you doing, Sonny? I sure hope you finda the clues." Mario offers."
					)
					((Said 'talk/coroner')
						(if (> 3 global182 0)
							(Print 28 19) ; "The coroner says, "I'll take the body as soon as you're finished with it, Bonds.""
						)
					)
					((Said 'talk/man')
						(if local1
							(Print 28 20) ; "Who are you talking to?"
						else
							(Print 28 21) ; "Get a hold of yourself! This guy is DEAD!"
						)
					)
					((Said 'look/face')
						(Print 28 22) ; "The murdered man looks familiar, but you can't place his face..."
						(Print 28 23) ; "Wait..." you think, "I know him! That's Woody Roberts!"
						(SetScore 1 141)
						(Print 28 24) ; "Suddenly it all comes back. "He testified at Bains' trial last year.""
					)
					((Said 'look/body,person,man')
						(Print 28 25) ; "Looks like he took a bullet in the head. There are no other obvious wounds."
					)
					((Said 'look/injury,hole,head,burn')
						(Print 28 26) ; "You see what appear to be powder burns around the wound indicating that the gun was very close to the victim's head."
					)
					((Said 'look/cloth')
						(Print 28 27) ; "The victim is dressed in expensive, but old, ill-fitting clothes. Perhaps he had been well-off once, but no longer."
					)
					((Said 'frisk,look/pocket,cloth')
						(Print 28 28) ; "Someone has carefully emptied this man's pockets. You find nothing."
					)
					(
						(or
							(Said 'frisk/body,person,man')
							(Said 'look,frisk/hand')
						)
						(if (not local1)
							(if (== ((gInventory at: 24) owner:) 28) ; envelope_corner
								(Print 28 29) ; "Searching thoroughly, you find a corner of an envelope clutched in the victim's left hand."
							else
								(Print 28 30) ; "Carefully, you search the body and find..."
								(Print 28 31) ; "...nothing."
							)
						else
							(Print 28 32) ; "The body has been removed."
						)
					)
					((Said 'drop/corner')
						(if (gEgo has: 24) ; envelope_corner
							(Print 28 33) ; "You decide to keep the envelope corner as evidence."
						else
							(Print 28 34) ; "You don't have it."
						)
					)
					((Said 'get,remove/corner')
						(if (and (not local1) (IsItemAt 24)) ; envelope_corner
							(gEgo get: 24) ; envelope_corner
							(SetScore 2)
							(Print 28 35) ; "You pry the stiff fingers loose and take the corner of an envelope."
							(if (== global182 0)
								(= local0 25)
							)
						else
							(Print 28 36) ; "There is nothing like that here."
						)
					)
					((Said 'get/note,newspaper')
						(if (and local1 (IsItemAt 6)) ; death_threat
							(self changeState: 1)
						else
							(Print 28 37) ; "You don't see any of those here."
						)
					)
					(
						(or
							(Said 'exit[/trunk,lid]')
							(Said 'get<out')
							(Said 'walk')
						)
						(SetFlag 153)
						(self changeState: 3)
					)
					((Said 'close[/trunk,lid]')
						(Print 28 38) ; "Closing the trunk would hinder the investigation."
						(SetFlag 153)
						(self changeState: 3)
					)
				)
			)
		)
	)
)

