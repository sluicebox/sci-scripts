;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use n823)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	inPlane 0
)

(local
	local0
)

(instance inPlane of Rm
	(properties
		picture 44
	)

	(method (init)
		(Load rsVIEW 44)
		(super init:)
		(HandsOff)
		(gIceGlobalSound
			number: (proc0_5 83)
			owner: gGame
			priority: 1
			loop: -1
			play:
		)
		(gAddToPics add: head doit:)
		(cloud1 init: ignoreActors: 1 setScript: (Clone cloudScript))
		(cloud2 init: ignoreActors: 1 setScript: (Clone cloudScript))
		(if (== global132 2)
			(cloud3 init: ignoreActors: 1 setScript: (Clone cloudScript))
			(cloud4 init: ignoreActors: 1 setScript: (Clone cloudScript))
		)
		(switch gPrevRoomNum
			(1 ; openingScene
				(self setScript: flyToWashingtonScript)
			)
			(18 ; pentagonFront
				(self setScript: flyToHawaiiScript)
			)
		)
	)
)

(instance flyToWashingtonScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			(if local0
				(Display 44 0 dsRESTOREPIXELS local0)
				(self cue:)
			)
			(event claimed: 1)
		)
	)

	(method (cue)
		(= cycles (= seconds 0))
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Display 44 1 dsALIGN alLEFT dsCOORD 20 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "As you climb to 45,000 feet above the South Pacific on your way to Washington, D.C., you sit back and begin to relax for the long flight."
				(= seconds 10)
			)
			(1
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 2 dsALIGN alLEFT dsCOORD 20 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "Soon, you find yourself asleep and dreaming of the island paradise you just left."
				(= seconds 10)
			)
			(2
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 3 dsALIGN alLEFT dsCOORD 20 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "Fortunately, you were able to sleep most of the way. Happy the flight is over, you land at Dulles Airport."
				(= seconds 10)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 17) ; dullesAirport
			)
		)
	)
)

(instance flyToHawaiiScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			(if local0
				(Display 44 0 dsRESTOREPIXELS local0)
				(self cue:)
			)
			(event claimed: 1)
		)
	)

	(method (cue)
		(= cycles (= seconds 0))
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (Display 44 4 dsALIGN alLEFT dsCOORD 20 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "You board the plane for Pearl Harbor. After finding your seat, you settle back and drift into deep thought."
				(= seconds 10)
			)
			(1
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 5 dsALIGN alLEFT dsCOORD 10 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "You begin to ponder the mission ahead of you. "Unbelievable," you muse, "The magnitude of this operation is overwhelming.""
				(= seconds 10)
			)
			(2
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 6 dsALIGN alLEFT dsCOORD 10 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "As the big 747 soars westward at 480 knots, you continue in thought, "It's amazing," you think, "this one cowardly act of kidnapping an Ambassador has brought two super powers to each other's throats."
				(= seconds 10)
			)
			(3
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 7 dsALIGN alLEFT dsCOORD 30 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "You know the President will not back down on his promise to punish the perpetrators of this dastardly deed."
				(= seconds 10)
			)
			(4
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 8 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "And you shudder to think what nightmare may come upon the human race should this mission fail."
				(= seconds 10)
			)
			(5
				(Display 44 0 dsRESTOREPIXELS local0)
				(if (gEgo has: 0) ; Envelope
					(client setScript: ordersScript)
				else
					(= local0 (Display 44 9 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "Thoughts of the enormous load you now feel resting on your shoulders tire you, and you fall into a fitful slumber."
				)
				(= seconds 10)
			)
			(6
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 10 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "The stewardess wakes you with the announcement for all passengers to fasten their seat belts in preparation for the descent."
				(= seconds 10)
			)
			(7
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 11 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "As the big 747 banks left into its landing pattern, you look down at a most spectacular view of Pearl Harbor."
				(= seconds 10)
			)
			(8
				(Display 44 0 dsRESTOREPIXELS local0)
				(HandsOn)
				(proc823_0 204)
				(gCurRoom newRoom: 22) ; honoluluAirportRm
				(gIceGlobalSound fade:)
			)
		)
	)
)

(instance ordersScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evKEYBOARD) (event claimed:))
			(return)
		)
		(if local0
			(Display 44 0 dsRESTOREPIXELS local0)
			(self cue:)
		)
		(event claimed: 1)
	)

	(method (cue)
		(= cycles (= seconds 0))
		(super cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hand init: setLoop: 0 setCel: 1 setMotion: MoveTo 155 158 self)
			)
			(1
				(= local0 (Display 44 12 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "You carefully review the orders temporarily assigning you to the USS Blackhawk."
				(= seconds 10)
			)
			(2
				(hand setMotion: MoveTo 169 172 self)
			)
			(3
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 13 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "Sometime later, the stewardess makes the announcement for all passengers to fasten their seat belts in preparation for the descent."
				(= seconds 10)
			)
			(4
				(Display 44 0 dsRESTOREPIXELS local0)
				(= local0 (Display 44 11 dsALIGN alLEFT dsCOORD 40 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS)) ; "As the big 747 banks left into its landing pattern, you look down at a most spectacular view of Pearl Harbor."
				(= seconds 10)
			)
			(5
				(Display 44 0 dsRESTOREPIXELS local0)
				(HandsOn)
				(proc823_0 204)
				(gCurRoom newRoom: 22) ; honoluluAirportRm
				(gIceGlobalSound fade:)
			)
		)
	)
)

(instance cloudScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= seconds (Random 3 10))
			)
			(1
				(switch (Random 0 3)
					(0
						(= temp0 2)
						(= temp1 1)
						(= temp2 71)
					)
					(1
						(= temp0 4)
						(= temp1 2)
						(= temp2 81)
					)
					(2
						(= temp0 8)
						(= temp1 3)
						(= temp2 92)
					)
					(3
						(= temp0 16)
						(= temp1 4)
						(= temp2 107)
					)
				)
				(client
					posn: 290 temp2
					setLoop: 1
					setCel: (Random 0 1)
					setPri: temp1
					setStep: temp0 1
					setMotion: MoveTo -10 temp2 self
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance head of PV
	(properties
		y 189
		x 110
		view 44
		priority 14
	)
)

(instance hand of Act
	(properties
		y 172
		x 169
		view 44
		cel 1
	)
)

(instance cloud1 of Act
	(properties
		view 44
	)
)

(instance cloud2 of Act
	(properties
		view 44
	)
)

(instance cloud3 of Act
	(properties
		view 44
	)
)

(instance cloud4 of Act
	(properties
		view 44
	)
)

