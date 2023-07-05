;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 509)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	sForReg 0
)

(synonyms
	(branch arm branch)
)

(local
	local0
	local1
)

(instance sForReg of Rgn
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/boulder')
							(Print 509 0) ; "The rocks are insignificant here."
						)
						((Said '/dirt')
							(Print 509 1) ; "You see nothing of importance on the ground."
						)
						((Said '/bush')
							(Print 509 2) ; "You don't see many shrubs here."
						)
						((or (Said '/sky') (Said '<up'))
							(if (not gNight)
								(Print 509 3) ; "Despite this awful forest, the sky is quite nice and blue."
							else
								(Print 509 4) ; "It's easy to see by the light of a full moon."
							)
						)
						((Said '/grass')
							(Print 509 5) ; "There is little grass here."
						)
						((Said '/flora')
							(Print 509 6) ; "All you see are these awful trees!"
						)
						((Said '/blossom')
							(Print 509 7) ; "There are not many flowers here."
						)
						((Said '/forest')
							(Print 509 8) ; "These are vicious looking trees, aren't they? Best to stay clear of them!"
						)
						((Said '/eye')
							(Print 509 9) ; "You'd swear that these trees were LOOKING at you...! But that's impossible."
						)
						(else
							(event claimed: 0)
						)
					)
				)
				((Said 'get/blossom')
					(Print 509 10) ; "There are no flowers here!"
				)
				((Said 'climb/boulder')
					(Print 509 11) ; "You don't like to climb rocks."
				)
				((Said 'climb/forest')
					(Print 509 12) ; "You've GOT to be KIDDING!!"
				)
				((Said 'kill/forest')
					(Print 509 13) ; "That would be impossible for you to do."
				)
				(
					(or
						(Said 'break,hit,cut/branch,branch,branch,forest')
						(Said 'swing,use,wave/ax')
					)
					(cond
						(global112
							(Print 509 14) ; "That's not necessary anymore."
						)
						(
							(and
								(not global112)
								(not ((Inv at: 16) ownedBy: gEgo)) ; Axe
							)
							(Print 509 15) ; "How would you go about doing that?"
						)
						((gEgo has: 16) ; Axe
							(gGame changeScore: 4)
							(gSounds eachElementDo: #stop 0)
							(= global112 1)
							(gEgo setScript: chop)
							(chop changeState: 1)
						)
					)
				)
				((Said 'hide/forest')
					(Print 509 16) ; "Go ahead, try it."
				)
				((Said 'talk')
					(Print 509 17) ; "These trees do not have the capability to talk."
				)
				((Said 'give>')
					(if
						(and
							(= temp0 (gInventory saidMe:))
							(gEgo has: (gInventory indexOf: temp0))
						)
						(Print 509 18) ; "The scary trees only want YOU!"
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance chop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo view: 86 setCycle: Fwd)
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(2
				(gEgo view: 2 setCycle: Walk)
				(Print 509 19) ; "The trees tremble at your might, and are frightened by your axe. They will not bother you further."
				(HandsOn)
				(switch gCurRoomNum
					(11
						(= local0 (Blk new:))
						(local0 left: 212 top: 103 right: 224 bottom: 106)
						(gEgo observeBlocks: local0)
					)
					(12
						(= local0 (Blk new:))
						(= local1 (Blk new:))
						(local0 left: 197 top: 112 right: 230 bottom: 117)
						(local1 left: 170 top: 108 right: 185 bottom: 110)
						(gEgo observeBlocks: local0 local1)
					)
				)
			)
		)
	)
)

