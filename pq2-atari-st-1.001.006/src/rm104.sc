;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm104 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(Print &rest #at -1 15)
)

(instance plane of Act
	(properties)
)

(instance gloveBox of View
	(properties)
)

(instance gloveBoxDoor of View
	(properties)
)

(instance rm104 of Rm
	(properties
		picture 50
		style 3
	)

	(method (init)
		(HandsOff)
		(User canInput: 1)
		(self setLocales: 153)
		(Load rsVIEW 257)
		(Load rsVIEW 74)
		(gloveBox view: 257 loop: 2 cel: 0 posn: 264 189 setPri: 0 init:)
		(gloveBoxDoor view: 257 loop: 3 cel: 0 posn: 260 182 setPri: 0 init:)
		(plane view: 74 setLoop: 0 setPri: 1 init: setScript: planeScript)
		(= local2 1)
		(= local3 1)
		(super init:)
		(self setScript: rm104Script)
	)
)

(instance rm104Script of Script
	(properties)

	(method (doit)
		(if (> local4 1)
			(-- local4)
		)
		(if (== local4 1)
			(= local4 0)
			(rm104Script cue:)
		)
		(if (> local5 1)
			(-- local5)
		)
		(if (== local5 1)
			(= local5 0)
			(planeScript cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SL enable:)
				(= local4 (Random 100 450))
			)
			(1
				(planeScript changeState: 0)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					(
						(or
							(Said 'get<out[/auto]')
							(Said 'exit[/auto]')
							(Said 'close/door')
						)
						(HandsOn)
						(gCurRoom newRoom: 14)
					)
					((Said 'get/vin,badge,number')
						(localproc_0 104 0) ; "You read the "VIN" number: "S1234T10.""
						(SetScore 1 77)
					)
					((or (Said 'use/tape') (Said 'get,hoist/print,clue'))
						(if (not (gEgo has: 19)) ; thumbprint
							(if local0
								(global123 setPri: 0)
								(localproc_0 104 1 83) ; "Gently and carefully, you use the fingerprint tape to lift the clear print impression from the rear view mirror."
								(SetScore 3)
								(gEgo get: 19) ; thumbprint
								(global123 setPri: 15)
							else
								(localproc_0 104 2) ; "You haven't found a valid print yet."
							)
						else
							(localproc_0 104 3) ; "You are unable to pick up another valid print."
						)
					)
					((Said 'open/compartment,box')
						(if local2
							(gloveBox setPri: 12)
							(gloveBoxDoor setPri: 13)
						)
						(gloveBoxDoor setCel: 1)
						(= local3 0)
						(localproc_0 104 4 83) ; "The glove box appears to be empty."
					)
					((Said 'close/compartment,box')
						(gloveBoxDoor setCel: 0)
						(gloveBox setPri: 0)
						(gloveBoxDoor setPri: 0)
						(= local3 1)
						(= local2 1)
					)
					((Said 'look>')
						(cond
							((Said '[<around,at,in][/auto]')
								(localproc_0 104 5) ; "It's pretty clean. You start to look around at specific parts of the automobile, searching for clues or evidence."
							)
							((Said '/dirt,crumb,cookie,leaf')
								(localproc_0 104 6) ; "Just old car dirt."
							)
							((Said '/vin,badge,number')
								(localproc_0 104 0) ; "You read the "VIN" number: "S1234T10.""
								(SetScore 1 77)
							)
							((Said '/dash,console')
								(localproc_0 104 7) ; "Simulated leather."
							)
							((Said '/mirror')
								(if (or local0 (gEgo has: 19)) ; thumbprint
									(localproc_0 104 8) ; "It's covered with fingerprint powder."
								else
									(localproc_0 104 9) ; "A shiny surface is liable to pick up good prints."
								)
							)
							((Said '/airplane')
								(localproc_0 104 10) ; "Occasionally, an airplane taking off or landing can be seen through the car window."
							)
							((Said '/handle[<door]')
								(localproc_0 104 11) ; "It's the lift-out kind."
							)
							((Said '/pane')
								(localproc_0 104 12) ; "Tinted glass."
							)
							((Said '<in,in/compartment,box')
								(if local3
									(localproc_0 104 13) ; "You can't see inside. It's closed."
								else
									(localproc_0 104 14) ; "You're already doing that."
								)
							)
							((Said '/compartment,box')
								(= local2 0)
								(gloveBox setPri: 12)
								(gloveBoxDoor setPri: 13)
								(if (or local2 local3)
									(localproc_0 104 15 83) ; "Simulated metal exterior."
								else
									(localproc_0 104 16) ; "You look very closely, but you see nothing remarkable."
								)
							)
							((Said '/knob,gear,shift,baton,gearshift')
								(localproc_0 104 17) ; "Three-speed automatic."
							)
							((Said '/column,wheel')
								(localproc_0 104 18) ; "The wheel has a wrap-around cover; the column contains accessory controls."
							)
							((or (Said '/horn') (Said '/ring<horn'))
								(localproc_0 104 19) ; "The horn ring is in the lower half of the steering wheel."
							)
							((Said '/tray,ashtray')
								(localproc_0 104 20) ; "Somebody has been using it."
							)
							((Said '/floor')
								(localproc_0 104 21) ; "You see some cookie crumbs and an occasional dead leaf. There is nothing significant."
							)
							((Said '/bench')
								(localproc_0 104 22) ; "The seats are made of soft, dark blue cloth. They are empty."
							)
							((Said '/door')
								(localproc_0 104 23) ; "There is nothing at all unusual about the doors."
							)
							((Said '/roof')
								(localproc_0 104 24) ; "The vinyl is in excellent shape."
							)
						)
					)
					((Said 'read,find,look/vin,badge,number')
						(localproc_0 104 0) ; "You read the "VIN" number: "S1234T10.""
					)
					((Said 'frisk>')
						(cond
							((Said '/compartment,box')
								(if local3
									(localproc_0 104 25) ; "You can't search it yet. It's closed."
								else
									(localproc_0 104 26) ; "OK. You search, but you find nothing."
								)
							)
							((Said '/auto')
								(localproc_0 104 27) ; "Nothing unusual at all. No obvious evidence."
							)
							((Said '/bench')
								(localproc_0 104 28) ; "You reach into, under, and around the front and back seats, but you come up empty-handed."
							)
						)
					)
					((or (Said 'dust>') (Said 'use,apply/powder>'))
						(if (gEgo has: 10) ; field_kit
							(global122 setPri: 0)
							(global120 setPri: 0)
							(cond
								((Said '/handle[<door]')
									(localproc_0 104 29 83) ; "Not even a partial print."
								)
								((Said '/compartment,box')
									(localproc_0 104 30 83) ; "You carefully dust the glove box, but there are no useful impressions."
								)
								((Said '/column')
									(localproc_0 104 31) ; "Nice try! The steering column is chromed and shiny, but the prints are too smeared to be readable."
								)
								((Said '/knob,gear,shift,baton,gearshift')
									(localproc_0 104 32) ; "The textured surface won't take a print."
								)
								((or (Said '/horn') (Said 'ring[<horn]'))
									(localproc_0 104 33 83) ; "It's too smeared for a clear impression."
								)
								((Said '/pane')
									(localproc_0 104 33 83) ; "It's too smeared for a clear impression."
								)
								((Said '/tray,ashtray')
									(localproc_0 104 34 83) ; "There is so much ash that it looks like it's already been dusted for prints. You find nothing useful."
								)
								((Said '/dash,console')
									(localproc_0 104 35 83) ; "No good prints here!"
								)
								((Said '/mirror')
									(if (not (gEgo has: 19)) ; thumbprint
										(localproc_0 104 36) ; "You carefully dust the rear view mirror, and come up with one good print."
										(= local0 1)
									else
										(localproc_0 104 37) ; "You found a good print there already."
									)
								)
							)
							(global122 setPri: 15)
							(global120 setPri: 15)
						else
							(localproc_0 104 38) ; "You can't dust the car for prints. You don't have your field kit."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance planeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(plane
					setCel: 1
					posn: 360 44
					xStep: 8
					setMotion: MoveTo 131 44 self
					init:
					startUpd:
				)
			)
			(1
				(plane stopUpd:)
				(= local5 80)
			)
			(2
				(plane
					setCel: 0
					posn: 149 10
					xStep: 4
					setMotion: MoveTo 335 10 self
					startUpd:
				)
			)
		)
	)
)

