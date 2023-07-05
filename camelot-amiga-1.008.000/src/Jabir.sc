;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Actor)

(public
	Jabir 0
	jabirHead 1
	jabirWindow 2
)

(instance jabirHead of Prop
	(properties
		z 40
		view 392
		loop 7
		cycleSpeed 1
	)
)

(instance jabirWindow of SysWindow
	(properties
		color 14
		back 0
		title {Jabir ibn Hamid}
		brTop 24
		brLeft 50
		brBottom 80
		brRight 200
	)
)

(instance Jabir of Act
	(properties
		view 389
	)

	(method (delete)
		(jabirHead dispose: delete:)
		(= global169 0)
		(super delete:)
		(DisposeScript 130)
	)

	(method (init)
		(Load rsVIEW 389)
		(Load rsVIEW 308)
		(Load rsVIEW 392)
		(Load rsVIEW 394)
		(Load rsVIEW 397)
		(Load rsVIEW 399)
		(Load rsVIEW 395)
		(Load rsVIEW 23)
		(Load rsSCRIPT 180)
		(Load rsSCRIPT 910)
		(Load rsSCRIPT 912)
		(Load rsSOUND 102)
		(Load rsSOUND 103)
		(Load rsSOUND (proc0_20 104))
		(Load rsSOUND (proc0_20 105))
		(Load rsSOUND (proc0_20 106))
		(Load rsSOUND 79)
		(super init:)
		(if (!= global189 9)
			(= global169 1)
		)
		(jabirHead init:)
		(gTObj
			actor: jabirHead
			tLoop: 7
			tWindow: jabirWindow
			noWidth: 1
			init:
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (not script)
			(cond
				((or (Said 'pay[/hamid]') (Said 'give,count[/coin][/hamid]'))
					(if (== gCurRoomNum 36)
						(event claimed: 0)
					else
						(Talk 130 0) ; "I thank you, habib, but you need not pay me until we reach Jerusalem."
					)
				)
				((Said 'greet[/hamid]')
					(Talk 130 1) ; "Sa'alam aleikem. Peace be unto you."
				)
				((Said 'rob,grab,press,search,(rob<from)/hamid,body')
					(Talk 130 2) ; "Do not lay hands upon me, foreigner!"
				)
				(
					(or
						(Said 'look,get/dagger')
						(Said 'ask,tell[/me,hamid]/dagger')
					)
					(Talk 130 3) ; "Eh? Dagger? I have no dagger, habib."
				)
				((Said 'get,buy,bargain/canteen,(fur<water)')
					(Talk 130 4) ; "I did not bring one for this trip. The desert is no threat to me."
				)
				((Said 'give/lodestone')
					(Talk 130 5) ; "An odd trinket, of no use to me. I would prefer money."
				)
				((Said 'sell,bargain,bargain')
					(Talk 130 6) ; "I would prefer money in exchange for my services. We will discuss it at Jerusalem."
				)
				(
					(or
						(Said 'look,use/canteen,(fur<water)')
						(Said 'ask,tell[/me,hamid]/canteen,(fur<water)')
					)
					(if (== gCurRoomNum 44)
						(event claimed: 0)
					else
						(Talk 130 7) ; "You have no waterskin? A pity. I need none, for I can well endure the desert. You had best follow me closely to reach the water you need."
					)
				)
				(
					(or
						(event claimed:)
						(and
							(!= (event type:) evSAID)
							(not
								(and
									(== (event type:) evMOUSEBUTTON)
									(& (event modifiers:) emSHIFT)
								)
							)
						)
					)
					(return)
				)
				((or (MouseClaimed Jabir event) (MouseClaimed jabirHead event))
					(if (== global189 9)
						(Print 130 8) ; "Jabir means to kill you, Arthur!"
					else
						(Print 130 9) ; "He looks a dry and hard man, as one might look from a lifetime in harsh deserts."
					)
				)
				((or (Said 'talk,ask[/hamid]>') (Said 'tell[/me]>'))
					(cond
						(
							(or
								(Said
									'/gawain,galahad,guenevere,grail,lancelot'
								)
								(Said
									'//gawain,galahad,guenevere,grail,lancelot'
								)
							)
							(Talk 130 10) ; "This name means nothing to me."
						)
						(
							(or
								(Said '/jerusalem,wall,gate')
								(Said '//jerusalem,wall,gate')
							)
							(Talk 130 11) ; "You will see the walls of Jerusalem soon enough, but first you must have water."
						)
						(
							(or
								(Said '/direction,path,path')
								(Said '//direction,path,path')
							)
							(Talk 130 12) ; "Only one such as I knows the unmarked paths of the desert."
						)
						(
							(or
								(Said '/delusion,delusion')
								(Said '//delusion,delusion')
							)
							(Talk 130 13) ; "Beware of mirages. They will only lead you astray to your death."
						)
						((== gCurRoomNum 44)
							(event claimed: 0)
						)
						((or (Said '/coin,fee') (Said '//coin,fee'))
							(Talk 130 0) ; "I thank you, habib, but you need not pay me until we reach Jerusalem."
						)
						((or (Said '/ass') (Said '//ass'))
							(Talk 130 14) ; "Your mule will last no longer than you without water."
						)
						(
							(or
								(Said '/water,spring,pool,spring,lake')
								(Said '//water,spring,pool,spring,lake')
							)
							(if (== gCurRoomNum 45)
								(event claimed: 0)
							else
								(Talk 130 15) ; "Follow me. I will lead you directly to water."
							)
						)
						((or (Said '/wadi,oasis') (Said '//wadi,oasis'))
							(if (== gCurRoomNum 45)
								(event claimed: 0)
							else
								(Talk 130 16) ; "I know where every wadi is hidden. Follow me."
							)
						)
						(else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

